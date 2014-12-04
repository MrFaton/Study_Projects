package net.mr_faton.OOP.App19_Overloading.App04;

/**
 * Created by Faton on 04.12.2014.
 */
public class App04 {
    public static void main(String[] args) {
        f(10);
        f((short) 10);
    }

    public static void f(double k) {
        System.out.println("double: " + k);
    }
}
/*
Хотя если у компилятора нет выбора, т.е. он не может расширить тип, сделать его больше, то он просто преобразует
int и short в double
 */