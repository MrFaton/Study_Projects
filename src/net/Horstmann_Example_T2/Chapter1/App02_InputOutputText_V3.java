package net.Horstmann_Example_T2.Chapter1;

import java.io.*;

/**
 * Created by Mr_Faton on 06.02.2015.
 */
public class App02_InputOutputText_V3 {
    public static void main(String[] args) {
        String fileIn = "C:\\testIn.txt";
        String fileOut = "C:\\testOut.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(fileIn));
             BufferedWriter out = new BufferedWriter(new FileWriter(fileOut))) {
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                out.write(str);
                out.newLine();
                out.flush();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден...");
            return;
        } catch (IOException ex) {
            System.out.println("Ошибка чтения из файла");
            return;
        }
    }
}
