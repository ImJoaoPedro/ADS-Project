package consultant.client;

import frontend.Frontend;

import javax.swing.*;
import java.awt.*;

public class Client {

    JFrame frame;

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public Client(){

    }

    public void start(){
        frame = new Frontend();
        frame.setVisible(true);
        frame.setSize(600,500);
        frame.setPreferredSize(new Dimension(600,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
