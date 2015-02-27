package net.Junior.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created by Mr_Faton on 27.02.2015.
 */
public class App01_WebServer_V1 {
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static Calendar calendar;

    public static void main(String[] args) {
        try {
            //если указать другой порт, то в браузере после ":" нужно указывать порт ServerSocket-a
            serverSocket = new ServerSocket(81);
            while (true) {
                System.out.println("Ожидаем соединения...");
                socket = serverSocket.accept();
                System.out.println("Соединене установлено");
                try (InputStream in = socket.getInputStream();
                     OutputStream out = socket.getOutputStream()) {
                    byte[] request = new byte[8192];
                    in.read(request);
                    System.out.println(new String(request, "US-ASCII"));

                    String gritting = "Привет, это комп Игоряна. Всё работает хорошо!";
                    out.write(gritting.getBytes("windows-1251"));
                    calendar = Calendar.getInstance();
                    String date ="\nДата на сервере: " + String.format("%tA %<td/%<tm/%<ty %<tT", calendar);
                    out.write(date.getBytes("windows-1251"));

                    out.flush();
                } finally {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
