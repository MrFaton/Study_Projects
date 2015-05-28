package net.mr_faton.Test;


import java.util.LinkedHashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("Hi");
        set.add("hello");
        set.add("hi");
        set.add("poom");
        set.add("hi");
        set.add("end");

        System.out.println(set);
    }

}