package net.mr_faton.OOP.App19_Overloading.App00;

/**
 * Created by Faton on 04.12.2014.
 */
public class App00 {
    public static void main(String[] args) {
        f(1);
        f("Hello");
//        f(1.5f);//Не работает, т.к. метода f с таким аргументом (float) нет
    }

    public static void f(int k) {
        System.out.println("int: " + k);
    }

    public static void f(String k) {
        System.out.println("String: " + k);
    }
}
