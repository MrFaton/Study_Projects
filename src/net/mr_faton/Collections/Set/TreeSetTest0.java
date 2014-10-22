package net.mr_faton.Collections.Set;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Faton on 22.10.2014.
 */
public class TreeSetTest0 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("ay");
        set.add("b");
        set.add("ax");
        System.out.println(set);
    }
}
