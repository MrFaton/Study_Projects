package net.mr_faton.Collections.Set;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by Faton on 22.10.2014.
 */
public class TreeSetTest3 {
    public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<>();
        set.add("dd");
        set.add("aa");
        set.add("cc");
        set.add("bb");

        System.out.println("Множестов: " + set);

        NavigableSet<String> subSet = set.tailSet("b", true);//Хотя в нашем списке и нет b, берётся с того места, где моглобы находиться b и до конца, но если бы оно было, то вывелся список включая b и до конца
        System.out.println("От b и до конца: " + subSet);
    }
}
