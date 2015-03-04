package net.mr_faton.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("twitter.com", 80);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        String str = "GET / HTTP/1.1" +
                "Host: twitter.com" +
                "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" +
                "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3" +
                "Accept-Encoding: gzip, deflate" +
                "Connection: keep-alive";
        out.write(str.getBytes("UTF-8"));
        out.flush();
        int ch = in.read();
        System.out.println("NOP");
        while (ch != -1) {
            System.out.println((char) ch);
        }
    }
}