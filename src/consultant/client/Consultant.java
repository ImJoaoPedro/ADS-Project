package consultant.client;

import com.n1analytics.paillier.EncryptedNumber;
import com.n1analytics.paillier.PaillierContext;
import com.n1analytics.paillier.PaillierPrivateKey;
import com.n1analytics.paillier.PaillierPublicKey;
import objects.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultant {

    private int quality = 0;
    private int desiredQuality;
    private int[] numbers;
    private int iterations = 0;
    private JTextArea textArea;

    public static void main(String[] args) {
        Consultant consultant = new Consultant(args);
        consultant.start();
    }

    public Consultant(String[] args){
        numbers = StringArrToIntArr(args);
        desiredQuality = numbers[0];
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void start(){
        setLogging();
        //Create KeyPair
        KeyPair kp = generateKeys();
        do{
            //Generates a Solution based on the Args
            Solution solution = generateSolution(numbers);

            //Encrypts Solution & Sends it
            EncryptedSolution encryptedSolution = new EncryptedSolution(kp, solution);
            Message message = new Message(encryptedSolution);
            sendMessage(message, kp);
        } while(quality < desiredQuality);
        System.out.println("Found desired quality: " + desiredQuality);
        print("Found desired quality: " + desiredQuality);
    }


    public void sendMessage(Message message, KeyPair kp) {
        try {
            Socket socket = new Socket("localHost", 4445);
            System.out.println("Connected");
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(message);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Message response = (Message) inputStream.readObject();
            readResponse(response, kp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readResponse(Message response, KeyPair kp) {
        System.out.println("received a response!");
        decrypt(response, kp);
    }

    private void decrypt(Message response, KeyPair kp) {
        PaillierPublicKey key = new PaillierPublicKey(kp.getPublicKey().getModulus());
        PaillierContext context = key.createSignedContext();
        EncryptedNumber quality = new EncryptedNumber(context, response.getSolution().getQuality(), response.getSolution().getQualityExponent());

        BigInteger decryptedQuality = kp.getPrivateKey().raw_decrypt(quality.calculateCiphertext());
        setQuality(decryptedQuality.intValue());
        System.out.println("Got this quality: "+decryptedQuality.toString());
    }

    public KeyPair generateKeys(){
        PaillierPrivateKey priK = PaillierPrivateKey.create(1024);
        PaillierPublicKey pubK = priK.getPublicKey();
        KeyPair keyPair = new KeyPair(priK, pubK);
        return keyPair;
    }

    public Solution generateSolution(int[] array) {
        int[] temp = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            temp[i] = array[i] + iterations;
        }
        Solution solution = new Solution(temp);
        iterations++;
        return solution;
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    private void print(String s){
        if(textArea != null){
            textArea.append(s);
            textArea.append("\n");
        }
    }

    private void setLogging(){
        Logger logger = Logger.getLogger("com.n1analytics.paillier");
        logger.setLevel(Level.OFF);
    }
}
