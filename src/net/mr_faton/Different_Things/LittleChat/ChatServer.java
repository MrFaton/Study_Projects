package net.mr_faton.Different_Things.LittleChat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;

/**
 * Created by root on 24.02.2015.
 */
public class ChatServer {
    public static void main(String[] args) {
        new Server().start();
    }
}



class Server {
    private ArrayList<PrintWriter> myClients = new ArrayList<>(5);
    private ServerSocket server;
    private Socket client;
    private PrintWriter writer;

    public void start() {
        try {
            server = new ServerSocket(5000);
            while (true) {
                System.out.println("Сервер запущен и ожидает соединений...");
                client = server.accept();
                System.out.println("Подключаем клиента...");
                writer = new PrintWriter(client.getOutputStream());
                myClients.add(writer);
                new Thread(new ClientHolder()).start();
                System.out.println("Клиент подключен!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class ClientHolder implements Runnable {
        private BufferedReader reader;
        private String message;
        @Override
        public void run() {
            System.out.println("поток клиента старотовал");
            try {
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                message = reader.readLine();
                System.out.println(message);
                writer.println(message);
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

