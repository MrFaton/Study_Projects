package net.mr_faton.Different_Things;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by Faton on 07.10.2014.
 */
public class DealConstruktor2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(asList("A", "B", "A"));
        System.out.println(list);
        System.out.println(new HashSet<>(list));
        ArrayList list2 = new ArrayList<>(new HashSet(list));
        Collections.sort(list2);
        System.out.println(list2);
    }
}
