package net.mr_faton.IO;

import java.io.*;

/**
 * Created by root on 09.10.2014.
 */
public class App06 {
    public static void main(String[] args) throws IOException {
        String str = "Hello";
        OutputStream dst = new FileOutputStream(new File("c:/tt.txt"), true);
        Writer writer = new OutputStreamWriter(dst, "UTF-8");
        writer.write(str);
        writer.flush();
        writer.close();
    }
}
