package net.mr_faton.OOP;

/**
 * Created by Faton on 17.11.2014.
 */
public class App05 {
    public static void main(String[] args) {
        fun(new int[]{10, 20, 30}, 1);
        fun("Hello!", 0);
//        fun(new Object(), 0); //эта строка выкинет наш IllegalArgumentException
    }

    public static void fun(Object obj, int index) {
        if (obj instanceof int[]) {
//            System.out.println(((int[]) obj)[1]); //- это сокращённая версия или ниже полная
            int[] myArray = (int[]) obj;
            System.out.println(myArray[index]);
        } else if (obj instanceof String) {
            System.out.println(((String) obj).charAt(index));
        } else {
            throw new IllegalArgumentException("В метод передали и не массив интов и не строку");
        }
    }
}
//Это плохой стиль ООП