package net.mr_faton.Collections.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 01.10.2014.
 */
public class App03 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println("1 " + set.add("a"));
        System.out.println("2 " + set.add("b"));
        System.out.println("3 " + set.add("a"));//не добавит, потому что такой элемент уже был
        System.out.println("4 " + set.add("c"));
        System.out.println("5 " + set);//необязан выводить в том порядке, в котором были записаны элементы

        set.remove(2);//эта штука не удаляет второй элемент! Метод remove() получает в виде аргумента объект, поэтому число 2 при помощи класса обёртки Integer превращают автоматом в объект и пытаются его удалить.
    }
}
