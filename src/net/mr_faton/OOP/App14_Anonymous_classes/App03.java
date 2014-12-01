package net.mr_faton.OOP.App14_Anonymous_classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 01.12.2014.
 */
public class App03 {
    public static void main(String[] args) {
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<Integer>() {
        };
        System.out.println(list0.getClass());
        System.out.println(list1.getClass());
    }
}
