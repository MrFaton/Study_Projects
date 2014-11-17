package net.mr_faton.OOP;

/**
 * Created by Faton on 17.11.2014.
 */
public class App04 {
    public static void main(String[] args) {
        Object obj = new Object();
        Integer int0 = new Integer(0);

        Class classObj = obj.getClass();
        Class classInt = int0.getClass();

        System.out.print("Является ли Object предком Integer? - ");
        System.out.println(classObj.isAssignableFrom(classInt));

        System.out.print("Является ли Integer предком Object? - ");
        System.out.println(classInt.isAssignableFrom(classObj));
    }
}
