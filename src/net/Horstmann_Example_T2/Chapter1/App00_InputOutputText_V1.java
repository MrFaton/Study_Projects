package net.Horstmann_Example_T2.Chapter1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

/**
 * Created by Mr_Faton on 06.02.2015.
 */
public class App00_InputOutputText_V1 {
    public static void main(String[] args) {
        String fileIn = "C:\\testIn.txt";
        String fileOut = "C:\\testOut.txt";
        //для чтения и записи файла будем использовать массив байт
        byte[] buf;
        String str = "";
        try (InputStream in = new BufferedInputStream(new FileInputStream(fileIn)); //Можно пользоваться буфферизированными потоками, а можно и не пользоваться буфферами
             OutputStream out = new BufferedOutputStream(new FileOutputStream(fileOut))) {
            //чтение из файла
            buf = new byte[in.available()];
            in.read(buf);
            str = new String(buf, "cp1251");

            //запись в файл
            out.write(buf);
            out.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден...");
            return;
        } catch (IOException ex) {
            System.out.println("Ошибка чтения из файла");
            return;
        }
        System.out.println(str);
    }
}
