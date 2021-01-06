package consultant.client;

import com.n1analytics.paillier.EncryptedNumber;
import com.n1analytics.paillier.PaillierContext;
import com.n1analytics.paillier.PaillierPrivateKey;
import com.n1analytics.paillier.PaillierPublicKey;
import objects.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.Socket;

public class Consultant {

    public static void main(String[] args) {
        Consultant consultant = new Consultant();

        //Create KeyPair
        KeyPair kp = consultant.generateKeys();

        //Generates a Solution based on the Args
        Solution solution = consultant.generateSolution(consultant.StringArrToIntArr(args));

        //Encrypts Solution
        EncryptedSolution encryptedSolution = new EncryptedSolution(kp, solution);

        Message message = new Message(encryptedSolution);

        consultant.sendMessage(message, kp);
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
        System.out.println(decryptedQuality.toString());
    }

    public KeyPair generateKeys(){
        PaillierPrivateKey priK = PaillierPrivateKey.create(1024);
        PaillierPublicKey pubK = priK.getPublicKey();
        KeyPair keyPair = new KeyPair(priK, pubK);
        return keyPair;
    }

    public Solution generateSolution(int[] array) {
        Solution solution = new Solution(array);
        return solution;
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

}
