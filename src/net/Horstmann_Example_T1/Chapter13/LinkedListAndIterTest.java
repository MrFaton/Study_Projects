package net.Horstmann_Example_T1.Chapter13;

import java.util.*;

/**
 * Created by root on 31.01.2015.
 */
public class LinkedListAndIterTest {
    public static void main(String[] args) {
        List<String> list1 = new LinkedList<>();
        list1.add("Bob");
        list1.add("Peter");
        list1.add("Alex");

        List<String> list2 = new LinkedList<>();
        list2.add("Juli");
        list2.add("Katy");
        list2.add("Suzi");
        list2.add("Vanessa");

        System.out.println("Вывести списки:");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");

        ListIterator<String> listIter1 = list1.listIterator();
        Iterator<String> iter = list2.iterator();

        //добавить все элементы из списка2 в список1 через одного
        while (iter.hasNext()) {
            if (listIter1.hasNext()) {
                listIter1.next();
            }
            listIter1.add(iter.next());
        }
        System.out.println("добавить все элементы из списка2 в список1 через одного:");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");

        //удалить каждый второй элемент в списке2
        iter = list2.iterator();
        while (iter.hasNext()) {
            iter.next();
            if (iter.hasNext()) {
                iter.next();
                iter.remove();
            }
        }
        System.out.println("удалить каждый второй элемент в списке2:");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");

        //удалить все элементы из списка1, которые содержаться в списке2
        list1.removeAll(list2);
        System.out.println("удалить все элементы из списка1, которые содержаться в списке2:");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");

        //конвертация списка1 в массив строк
        String[] str = new String[list1.size()];
        list1.toArray(str);
        System.out.println("конвертация списка1 в массив строк:");
        System.out.println(Arrays.toString(str));
    }
}
