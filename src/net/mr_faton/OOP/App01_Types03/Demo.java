package net.mr_faton.OOP.App01_Types03;

/**
 * Created by root on 16.11.2014.
 */
public class Demo {
    public static void main(String[] args) {
        fun(new Integer(50));
        fun(new Double(1.8));
    }

    public static void fun(Number ref) {
        System.out.println(ref.intValue());
    }
}
//Автоматическое неявное приведение типов в верх