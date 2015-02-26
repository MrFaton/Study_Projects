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
        Scanner in = new Scanner(System.in);
        System.out.println("Адрес сервера или Enter для localhost:");
        String serverAdres = in.nextLine();
        if (serverAdres.length() < 5) {
            serverAdres = "127.0.0.1";
            System.out.println("Выбран стандартный адрес: " + serverAdres);
        }
        System.out.println("Порт или Enter для 5000:");
        String port = in.nextLine();
        if (port.length() <= 1) {
            port = "5000";
            System.out.println("Выбран стандартный порт: " + port);
        }
        try {
            socket = new Socket(serverAdres, Integer.valueOf(port));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while (!socket.isClosed() && (receivedMessage = reader.readLine()) != null) {
                            System.out.println(receivedMessage);
                        }
                    } catch (IOException e) {
                        System.err.println("from here");
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    input = new Scanner(System.in);
                    while (!socket.isClosed()) {
                        inputMessage = input.nextLine();
                        try {
                            writer = new PrintWriter(socket.getOutputStream());
                            writer.println(inputMessage);
                            writer.flush();
                            if (inputMessage.equals("вввв")) {
                                reader.close();
                                writer.close();
                                socket.close();

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
