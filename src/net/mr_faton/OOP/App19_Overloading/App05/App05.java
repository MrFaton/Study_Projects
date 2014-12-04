package net.mr_faton.OOP.App19_Overloading.App05;

import java.util.*;

/**
 * Created by Faton on 04.12.2014.
 */
public class App05 {
    public static void main(String[] args) {
        f(new ArrayList());
    }


    public static void f(Object k) {
        System.out.println("Object: " + k);
    }


    public static void f(List k) {
        System.out.println("List: " + k);
    }
}
/*
Мы передаём в метод f ArrayList, но у нас 2 метода f - для List и для Object. Они обое являются предками для ArrayList.
Только List самый ближайший предок, поэтму ArrayList будет приведен к List и будет вызван f который с List.

Но если метод f с List закоментировать, то ArrayList лист будет приведен к Object и будет вызван f с Object. Только
List должен бысть импортирован с пакета util (import java.util.*;), а не с awt (java.awt.*;)
 */