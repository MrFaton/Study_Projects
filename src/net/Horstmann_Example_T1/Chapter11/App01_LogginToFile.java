package net.Horstmann_Example_T1.Chapter11;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mr_Faton on 30.01.2015.
 */
public class App01_LogginToFile {
    private static final Logger myLogger = Logger.getLogger("net.Horstmann_Example_T1.Chapter11.LoggingToFile");

    public static void main(String[] args) {
        myLogger.setLevel(Level.ALL);
        try {
            Handler myFileHandler = new FileHandler("C:\\ll.log", true);
            myLogger.addHandler(myFileHandler);
        } catch (IOException e) {
            System.out.println("НЕ могу открыть файл...");
        }
        myLogger.config("перед методом А");
        a();
        myLogger.config("после метода А");
    }

    public static void a() {
        myLogger.config("перед методом B");
        b();
        myLogger.config("после метода B");
    }

    public static void b() {
        myLogger.config("перед методом C");
        c();
        myLogger.config("после метода C");
    }

    public static void c() {
        myLogger.config("метод С работает");
    }
}
