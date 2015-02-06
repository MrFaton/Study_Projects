package net.Horstmann_Example_T2.Chapter1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Mr_Faton on 06.02.2015.
 */
public class App03_InputOutputText_V4_best {
    public static void main(String[] args) {
        String fileIn = "C:\\testIn.txt";
        String fileOut = "C:\\testOut.txt";

        try (Scanner in = new Scanner(new FileInputStream(fileIn), "cp1251");
             PrintWriter out = new PrintWriter(fileOut)) {
            String str;
            while (in.hasNext()) {
                str = in.nextLine();
                System.out.println(str);

                out.println(str);
            }
            out.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден...");
            return;
        }
    }
}
