package net.mr_faton.OOP;

/**
 * Created by Faton on 17.11.2014.
 */
public class App02 {
    public static void main(String[] args) {
        Integer int0 = new Integer(0);
        Integer int1 = new Integer(1);

        Class class0 = int0.getClass();
        Class class1 = int1.getClass();

        System.out.println(int0 == int1);
        System.out.println(int0.equals(int1));

        System.out.println(class0 == class1);
        System.out.println(class0.equals(class1));
    }
}
