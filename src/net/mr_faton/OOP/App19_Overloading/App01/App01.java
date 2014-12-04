package net.mr_faton.OOP.App19_Overloading.App01;

/**
 * Created by Faton on 04.12.2014.
 */
public class App01 {
    public static void main(String[] args) {
        f(1);
    }

    public static void f(int k) {
        System.out.println("int: " + k);
    }

//    public static int f(int k){
//        System.out.println("int: " + k);
//        return k;
//    }

//    public static void f (int k) throws Exception {
//        System.out.println("int: " + k);
//    }
}
/*
У нас есть 2 метода f с одинаковыми аргументами:
1-ый - ничего не возвращает
2-ой - возвращает int
Но так работать не будет, компилятор не сомжет их отличить только по возвращаемому значению.

Так же работать НЕ будет, если методы отличаются только объявление об исключении. Если единственное отличие - это
строка throws Exception.
 */