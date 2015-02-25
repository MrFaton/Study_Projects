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
    private ArrayList<ClientHolder> myClients = new ArrayList<>(5);
    private final Map<String, String> myUsers;
    private ServerSocket server;
    private Socket client;
    private Calendar calendar;

    public Server() {
        myUsers = new HashMap<>(5);
        myUsers.put("Mr_Faton", "907257");
        myUsers.put("genyka", "qwertyui");
    }

    public void start() {
        try {
            server = new ServerSocket(5000);
            while (true) {
                System.out.println("Сервер запущен и ожидает соединений...");
                client = server.accept();
                System.out.println("Подключаем клиента...");
                new Thread(new ClientHolder()).start();
                System.out.println("Клиент подключен!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void messageAll(String message, ClientHolder currentClient) {
        for (ClientHolder holdClient : myClients) {
            if (holdClient != currentClient) {
                holdClient.writeToClient.println(message);
                holdClient.writeToClient.flush();
            }
        }
    }

    class ClientHolder implements Runnable {
        private String message;
        private Socket socket = client;
        private PrintWriter writeToClient;
        private String login;
        private String password;

        @Override
        public void run() {
            try {
                writeToClient = new PrintWriter(client.getOutputStream());
                myClients.add(this);
                calendar = Calendar.getInstance();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writeToClient.println("Добро пожаловать на сервер :-) Дата на сервере: " +
                        String.format("%tA %<td/%<tm/%<ty %<tT", calendar));
                do {
                    writeToClient.println("Ваш логин:");
                    writeToClient.flush();
                    login = reader.readLine();
                    writeToClient.println("Ваш пароль:");
                    writeToClient.flush();
                    password = reader.readLine();
                    if (!(myUsers.get(login)).equals(password)) {
                        writeToClient.println("Логин или пароль не верен, попробуй ещё раз...");
                        writeToClient.flush();
                    }
                } while (!(myUsers.get(login)).equals(password));
                writeToClient.println("Авторизация пройдена успешно! Спасибо что пришёл " + login);
                writeToClient.flush();

                while (true) {
                    calendar = Calendar.getInstance();
                    message = login + ": " + reader.readLine() + " (в: " + String.format("%tT", calendar) + ")";
                    System.out.println(message);
                    messageAll(message, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

