package net.mr_faton.Different_Things.MeteoGET;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLEncoder;
import java.util.Base64;

public class MeteoPOST {
    public static void main(String[] args) throws IOException {
        String key = "kharmet:9NCzR##?3z";
        Base64.Encoder encoder = Base64.getEncoder();
        String auth = encoder.encodeToString(key.getBytes());
        final String authorization = "Authorization: Basic " + auth + "\r\n";

        String needData = "САУР*КИХА";
        final String needDataURLEncoded = URLEncoder.encode(needData, "koi8-u");
        final String quarryStr = "find=" + needDataURLEncoded + "&find1=&dip=1&srok=2015-03-19";

        final Socket socket = new Socket("91.216.232.13", 80);
        Thread thwriter = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OutputStream out = socket.getOutputStream();
                    out.write("POST /armua/jornal/show.phtml HTTP/1.1\r\n".getBytes());
                    out.write("Host: gcst.meteo.gov.ua\r\n".getBytes());
                    out.write("Connection: keep-alive\r\n".getBytes());
                    out.write("Cache-Control: max-age=0\r\n".getBytes());
                    out.write(authorization.getBytes());
                    out.write("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n".getBytes());
                    out.write("User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36\r\n".getBytes());
                    out.write("Accept-Encoding: gzip, deflate, sdch\r\n".getBytes());
                    out.write("Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4\r\n".getBytes());
                    out.write("Content-Type: application/x-www-form-urlencoded\r\n".getBytes());
                    out.write(("Content-Length: " + quarryStr.length() + "\r\n").getBytes());
                    out.write("\r\n".getBytes());
                    out.write((quarryStr + "\r\n").getBytes());
                    out.write("\r\n".getBytes());
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threader = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream in = socket.getInputStream();
                    byte[] buf = new byte[32768];
                    int count = in.read(buf);
                    String response = new String(buf, 0, count, "koi8-u");
                    System.out.println("Response: " + response);

                    count = in.read(buf);
                    response = new String(buf, 0, count, "koi8-u");
                    System.out.println("Response: " + response);

                    count = in.read(buf);
                    response = new String(buf, 0, count, "koi8-u");
                    System.out.println("Response: " + response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thwriter.start();
        threader.start();
    }
}

/*
http://gcst.meteo.gov.ua/armua/jornal/show.phtml?find=%F3%E1%F5%F2*%EB%E9%E8%E1&find1=&dip=1&srok=2015-03-19
 */