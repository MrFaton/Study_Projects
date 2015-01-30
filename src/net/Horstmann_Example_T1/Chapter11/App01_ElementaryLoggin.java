package net.Horstmann_Example_T1.Chapter11;

import java.util.logging.Logger;

/**
 * Created by Mr_Faton on 30.01.2015.
 */
public class App01_ElementaryLoggin {
    public static void main(String[] args) {
        Logger.getGlobal().info("Начало работы программы");
        a();
        Logger.getGlobal().info("Работа завершена");
    }

    public static void a() {
        Logger.getGlobal().info("Вошли в А");
        b();
        Logger.getGlobal().info("Вышли из А");
    }

    public static void b() {
        Logger.getGlobal().info("Вошли в B");
        c();
        Logger.getGlobal().info("Вышли из B");
    }

    public static void c() {
        Logger.getGlobal().info("Вошли в C");
        Logger.getGlobal().info("Вышли из C");
    }
}
