package net.mr_faton.OOP.App19_Overloading.App06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 04.12.2014.
 */
public class App06 {
    public static void main(String[] args) {
        f(new ArrayList());
    }


//    public static void f(List<String> k) {
//        System.out.println("List<String>: " + k);
//    }


    public static void f(List<Integer> k) {
        System.out.println("List<Integer>: " + k);
    }
}
/*
Оверлоадинг на дженериках невозможен. Так как джереники в Java реализованны по принципу стирания типов. Это значит что
до компиляции 2 разрых:
ArrayList<String>
ArrayList<Integer>
превратятся в один лист:
ArrayList Object-ов
Компилятор об этом знает и не допускает этого.
 */