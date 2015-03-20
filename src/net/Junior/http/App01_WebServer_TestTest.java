package net.Junior.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created by Mr_Faton on 27.02.2015.
 */
public class App01_WebServer_TestTest {
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static Calendar calendar;

    public static void main(String[] args) throws IOException{
        serverSocket = new ServerSocket(80);
        while (true) {
            System.out.println("Ожидаем соединения...");
            socket = serverSocket.accept();
            System.out.println("Соединене установлено");
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                byte[] request = new byte[8192];
                in.read(request);
                String text = new String(request, "UTF-8");


                System.out.println("Request-->");
                System.out.println(text);
                System.out.println("<--Request");


                String gritting = "HI every thing work";
                out.write(gritting.getBytes("UTF-8"));
                out.flush();
            } finally {
                socket.close();
            }
        }
    }
}