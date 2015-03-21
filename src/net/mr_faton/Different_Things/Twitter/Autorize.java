package net.mr_faton.Different_Things.Twitter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Mr_Faton on 21.03.2015.
 */
public class Autorize {
    private static final String LOGIN = "Mr_Faton";
    private static final String PASSWORD = "907257q2y";
    private static final String IP = "185.45.5.43";
    public static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket(InetAddress.getByName("twitter.com"), 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(new TwitterWriter()).start();
        new Thread(new TwitterReader()).start();
    }

    static class TwitterWriter implements Runnable {
        private OutputStream out;
        @Override
        public void run() {
            try {
                out = socket.getOutputStream();
                String[] requests = {
                        "GET / HTTP/1.1",
                        "Host: twitter.com",
                        "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:36.0) Gecko/20100101 Firefox/36.0",
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
                        "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3",
                        "Accept-Encoding: gzip, deflate",
                        "Connection: keep-alive",
                        ""
                };
                writeRequest(requests);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void writeRequest(String[] requests) throws IOException{
            for (String request : requests) {
                out.write((request + "\r\n").getBytes());
            }
            out.flush();
        }
    }

    static class TwitterReader implements Runnable {
        private InputStream in;
        @Override
        public void run() {
            try {
                in = socket.getInputStream();
                byte[] buf = new byte[64000];
                int count = in.read(buf);
                String response = new String(buf, 0, count, "UTF-8");
                System.out.println(response);

//                count = in.read(buf);
//                response = new String(buf, 0, count, "UTF-8");
//                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}