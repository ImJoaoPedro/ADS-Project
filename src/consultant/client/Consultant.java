package consultant.client;

import objects.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Consultant {

    public static void main(String[] args) {
        Consultant consultant = new Consultant();

        KeyPair kp = consultant.generateKeys();
        Solution solution = consultant.generateSolution(args[0]);
        consultant.encryptSolution(solution);

        Message message = new Message(kp.getPublicKey(), solution);

        consultant.sendMessage(message);
    }


    public void sendMessage(Message message) {
        try {
            Socket socket = new Socket("localHost", 4445);
            System.out.println("Connected");
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(message);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Message text = (Message) inputStream.readObject();
            System.out.println("received - "+text.getSolution().getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void encryptSolution(Solution s) {
        s.setText(s.getText()+" is now encrypted");
    }

    public KeyPair generateKeys(){
        PublicKey pubK = new PublicKey("asd");
        PrivateKey priK = new PrivateKey("qwe");
        return new KeyPair(priK, pubK);
    }

    public Solution generateSolution(String arg) {
        Solution s = new Solution("solucao 123");
        return s;
    }

}
