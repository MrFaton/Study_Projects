package net.Horstmann_Example_T2.Chapter1.App06_ReadWriteFile2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by root on 08.02.2015.
 */
public class ReadWriteFile_Test2 {
    public static void main(String[] args) {
        String partOfPath = "src\\net\\Horstmann_Example_T2\\Chapter1\\App06_ReadWriteFile2";
        Path original = Paths.get(partOfPath, "Test2.txt");
        Path copy1 = Paths.get(partOfPath, "Copy1.txt");
        Path copy2 = Paths.get(partOfPath, "Copy2.txt");

        copyMethod1(original, copy1);

        copyMethod2(original, copy2);
    }

    public static void copyMethod1(Path original, Path copy) {
        try (InputStream in = Files.newInputStream(original); OutputStream out = Files.newOutputStream(copy)) {

            int len = in.available();
            byte[] buffer = new byte[len];
            in.read(buffer);
            out.write(buffer);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void copyMethod2(Path original, Path copy) {
        try (Reader in = Files.newBufferedReader(original, Charset.forName("UTF-8"));
             Writer out = Files.newBufferedWriter(copy, Charset.forName("UTF-8"))) {

            int ch;
            while ((ch = in.read()) != -1) {
                out.write(ch);
            }
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
