package net.Junior.http;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 * Created by Mr_Faton on 01.03.2015.
 */
public class App02_WebServer_V2 {
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static ExecutorService threadPool;

    public static void main(String[] args) throws IOException {
        threadPool = new ThreadPoolExecutor(2, 64, 5L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(254));
        serverSocket = new ServerSocket(80);
        while (true) {
            System.out.println("Ожидаем соединения с клиентом...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключен!");
            threadPool.submit(new ClientSender(socket));
        }
    }
}

class ClientSender implements Runnable {
    private Socket socket;
    private File file = new File(System.getProperty("user.dir") + "\\src\\net\\Junior\\http\\Files\\Page2.html");

    ClientSender(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream();
             BufferedInputStream inFromFile = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buf = new byte[5000];
            int count = in.read(buf);
            System.out.println(new String(buf, 0, count, "US-ASCII"));

            count = inFromFile.read(buf);
            out.write(buf, 0, count);
            out.flush();

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

/*
Многопоточный веб-сервер. Реализован при помощь пула потокв, а именно ThreadPoolExecutor.
 */