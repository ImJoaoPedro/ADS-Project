package factory.client;

import com.n1analytics.paillier.EncryptedNumber;
import com.n1analytics.paillier.PaillierContext;
import com.n1analytics.paillier.PaillierPublicKey;
import objects.EncryptedSolution;
import objects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Factory {

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.listen();
    }

    public void listen() {
        try {
            ServerSocket serverSocket = new ServerSocket(4445);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) inStream.readObject();

                dealWithMessage(message);
                sendResponseMessage(socket,message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dealWithMessage(Message message){
        System.out.println("received a message!");

        EncryptedSolution solution = message.getSolution();
        evaluate(solution);
    }

    private void evaluate(EncryptedSolution solution) {
        PaillierPublicKey key = new PaillierPublicKey(solution.getModulus());
        PaillierContext context = key.createSignedContext();

        EncryptedNumber quality = context.encrypt(0);

        for(int i=0; i<solution.getNumbers().length; i++){
            quality = context.add(quality, new EncryptedNumber(context, solution.getNumbers()[i], solution.getExponents()[i]));
        }

        solution.setQuality(quality.calculateCiphertext());
        solution.setQualityExponent(quality.getExponent());
    }

    private void sendResponseMessage(Socket socket, Message message) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(message);
        socket.close();
    }

}
