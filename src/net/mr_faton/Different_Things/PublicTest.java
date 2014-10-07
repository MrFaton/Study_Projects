package net.mr_faton.Different_Things;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by Faton on 16.09.2014.
 */
public class PublicTest {
    public static void main(String[] args) {
        List<String> listArrayList = new ArrayList<>(asList("A", "B", "C"));
        List<String> listLinkedList = new LinkedList<>(asList("D", "E", "F"));
        Set<Integer> listHashSet = new HashSet<>(asList(1, 2, 3));

        testWay(listArrayList);
        testWay(listLinkedList);
        testWay(listHashSet);
    }

    public static void testWay(Collection list) {
        for (Object elem : list) {
            System.out.println(elem);
        }
    }
}