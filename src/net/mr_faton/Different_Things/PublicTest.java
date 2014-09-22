package net.mr_faton.Different_Things;


import java.io.*;
import java.net.URL;

/**
 * Created by Faton on 16.09.2014.
 */
public class PublicTest {
    public static void main(String[] args) throws IOException {
        InputStream src = new URL("http://expogas.net/").openStream();
        OutputStream dst = new FileOutputStream("c:/tempIO.txt");
        copy(src, dst);
    }

    public static void copy(InputStream src, OutputStream dst) throws IOException {
        int data;
        for (int k = 0; k < 3; k++) {
            data = src.read();
            dst.write(data);
        }
    }
}