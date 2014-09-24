package net.mr_faton.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by Faton on 22.09.2014.
 */
public class App03 {
    public static void main(String[] args) throws IOException {
        InputStream src = new URL("http://expogas.net/").openStream();
        OutputStream dst = new FileOutputStream("c:/tempIO.txt");
        copy(src, dst);
    }

    public static void copy(InputStream src, OutputStream dst) throws IOException {
        while (true) {
            int data = src.read();
            if (data != -1) {
                dst.write(data);
            } else {
                return;
            }
        }
    }
}
//когда метод read() возвращает "-1", это значит, что в потоке данные закончились, если read() возвращает от 0 до 255, то передаются данные