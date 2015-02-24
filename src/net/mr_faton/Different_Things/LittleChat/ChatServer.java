package net.mr_faton.Different_Things.LittleChat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;

/**
 * Created by root on 24.02.2015.
 */
public class ChatServer {
    private static ArrayList<PrintWriter> myClients = new ArrayList<>(2);
    public static void main(String[] args) {
        System.out.println();
        try {
            ServerSocket server = new ServerSocket(5000);
            while (true) {
                Socket client = server.accept();
                PrintWriter writer = new PrintWriter(client.getOutputStream());
                myClients.add(writer);
                new Thread(new Runnable() {
                    InputStreamReader inRead = new InputStreamReader(client.getInputStream());
                    BufferedReader reader = new BufferedReader(inRead);
                    @Override
                    public void run() {
                        try {
                            String message;
                            while ((message = reader.readLine()) != null) {

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            System.out.println("Не могу открыть сокет");
            System.exit(1);
        }
    }

    private static void tellAll(String message) {
        for (PrintWriter writer : myClients) {
            writer.write(message);
        }
    }
}
