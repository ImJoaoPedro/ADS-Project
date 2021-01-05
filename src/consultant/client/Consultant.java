package consultant.client;

import objects.Message;
import objects.PrivateKey;
import objects.PublicKey;
import objects.Solution;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Consultant {

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private PublicKey pubK;
    private PrivateKey priK;
    private Solution solution;

    public static void main(String[] args) {
        Consultant consultant = new Consultant();

        consultant.generateKeys();
        consultant.generateSolution();
        consultant.encryptSolution();
        
        Message message = new Message(consultant.getPubK(), consultant.getSolution());

        consultant.sendMessage(message);
    }


    public void sendMessage(Message message) {
        try {
            socket = new Socket("localHost", 4445);
            System.out.println("Connected");
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(message);

            inputStream = new ObjectInputStream(socket.getInputStream());
            Message text = (Message) inputStream.readObject();
            System.out.println("received - "+text.getSolution().getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void encryptSolution() {
        solution.setText(solution.getText()+" is now encrypted");
    }

    public void generateKeys(){
        pubK = new PublicKey("asd");
        priK = new PrivateKey("qwe");
    }

    public PublicKey getPubK() {
        return pubK;
    }

    public PrivateKey getPriK() {
        return priK;
    }

    public void generateSolution() {
        solution = new Solution("solucao 123");
    }

    public Solution getSolution() {
        return solution;
    }
}
