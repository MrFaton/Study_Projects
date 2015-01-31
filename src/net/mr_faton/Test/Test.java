package net.mr_faton.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        print(list1);
    }


    public static <E> void print (Collection<E> collection) {
        for (E element : collection) {
            System.out.println(element);
        }
    }
}