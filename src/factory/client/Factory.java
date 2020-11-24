package factory.client;

import objects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Factory {

    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ObjectInputStream inStream = null;
    private ObjectOutputStream outputStream = null;

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.listen();
    }

    public void listen() {
        try {
            serverSocket = new ServerSocket(4445);
            while(true){
                socket = serverSocket.accept();
                System.out.println("Connected");
                inStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) inStream.readObject();

                dealWithMessage(message);
                sendResponseMessage(socket,message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dealWithMessage(Message message){
        System.out.println("received - "+message.getSolution().getText());
        message.getSolution().setText("Evaluation of encrypted solution 123");
        System.out.println("sent - "+message.getSolution().getText());
    }

    private void sendResponseMessage(Socket socket, Message message) throws IOException {
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(message);
        socket.close();
    }

}
