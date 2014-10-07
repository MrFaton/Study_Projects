package net.mr_faton.Different_Things;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Faton on 07.10.2014.
 */
public class DealConstruktor {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(asList("A", "B", "A"));
        System.out.println(list);
        System.out.println(new HashSet<>(list));
    }
}
