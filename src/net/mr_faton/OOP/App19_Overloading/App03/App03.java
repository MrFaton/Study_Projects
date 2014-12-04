package net.mr_faton.OOP.App19_Overloading.App03;

/**
 * Created by Faton on 04.12.2014.
 */
public class App03 {
    public static void main(String[] args) {
        f(10);
        f((short) 10);
    }

    public static void f(long k) {
        System.out.println("long: " + k);
    }

    public static void f(double k) {
        System.out.println("double: " + k);
    }
}
/*
Вызывается всё время метод f с long, т.к. компилятор точно уверен, что при расширении типла с int и short до long
у значения ничего не потеряется.
 */