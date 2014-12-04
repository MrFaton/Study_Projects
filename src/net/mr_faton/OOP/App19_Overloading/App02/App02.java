package net.mr_faton.OOP.App19_Overloading.App02;

/**
 * Created by Faton on 04.12.2014.
 */
public class App02 {
    public static void main(String[] args) {
        f(100L);
        f(10);
        f((short) 1);

        f(50);//когда вызывается f с просто аргументом, то автоматически подразумевается что это int
    }

    public static void f(long k) {
        System.out.println("long: " + k);
    }

    public static void f(int k) {
        System.out.println("int: " + k);
    }

    public static void f(short k) {
        System.out.println("short: " + k);
    }
}
/*
Компилятор умеет различать типы примитовов. И он именно тот метод f, с типом которого мы просим его вызвать.
 */