package net.mr_faton.OOP;

/**
 * Created by Faton on 17.11.2014.
 */
public class App03 {
    public static void main(String[] args) {
        Integer int0 = new Integer(0);
        Integer int1 = new Integer(1);
        Object obj = new Object();

        Class class0 = int0.getClass();
        Class class1 = int1.getClass();
        Class classObj = obj.getClass();

        System.out.print("class0 == class1? - ");
        System.out.println(class0 == class1);

        System.out.print("class0.equals(class1)? - ");
        System.out.println(class0.equals(class1));

        System.out.print("class0 == classObj? - ");
        System.out.println(class0 == classObj);

        System.out.print("class0.equals(classObj)? - ");
        System.out.println(class0.equals(classObj));

    }
}
//Демонстрация различий между экземплярами класса java.lang.Class в PermGen-e