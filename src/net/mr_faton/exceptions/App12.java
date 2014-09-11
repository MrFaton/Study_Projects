package net.mr_faton.exceptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by root on 11.09.2014.
 */
public class App12 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("d:/tmp-1.txt");
            out = new FileOutputStream("d:/tmp-2.txt");
            out.write(in.read());
            out.flush();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }
    }
}
//Программа без try-resources