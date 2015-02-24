package net.mr_faton.Different_Things.LittleChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Mr_Faton on 24.02.2015.
 */
public class ChatClient {
    public static void main(String[] args) {
        new Client().start();
    }
}

class Client {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String receivedMessage;
    private String inputMessage;
    private Scanner input;

    public void start() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while ((receivedMessage = reader.readLine()) != null) {
                            System.out.println(receivedMessage);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    input = new Scanner(System.in);
                    inputMessage = input.nextLine();
                    try {
                        writer = new PrintWriter(socket.getOutputStream());
                        writer.write(inputMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
