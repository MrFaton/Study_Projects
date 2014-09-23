package net.mr_faton.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by root on 23.09.2014.
 */
public class App05 {
    public static void main(String[] args)throws IOException{
        InputStream src = new URL("http://expogas.net/").openStream();
        OutputStream dst = new FileOutputStream("c:/tempIO1.txt");
        copy(src, dst);
    }

    public static void copy (InputStream src, OutputStream dst) throws IOException {
        byte[] buff=new byte[64*1024];
        while (true) {
            int count = src.read(buff);
            System.out.println("записано всего байт в массив: "+count);
            if (count != -1) {
                dst.write(buff, 0, count);//В массиве байтов (buff) 65536(64*1024)байт, но в этот массив было записанно всего 7921 байт, поэтому такой агрумент метода write позволяет записать не 65536, а именно те 7921
            } else {
                return;
            }
        }
    }
}