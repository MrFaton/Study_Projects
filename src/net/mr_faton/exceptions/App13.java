package net.mr_faton.exceptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by root on 11.09.2014.
 */
public class App13 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("d:/tmp-1.txt");
             FileOutputStream out = new FileOutputStream("d:/tmp-2.txt")) {
            out.write(in.read());
            out.flush();
        }
    }
}
//try-resources (Пример кода с try-ресурсами)