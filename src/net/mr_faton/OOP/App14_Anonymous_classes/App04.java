package net.mr_faton.OOP.App14_Anonymous_classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 01.12.2014.
 */
public class App04 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {
            @Override
            public String toString() {
                return "Hello!";
            }
        };
        System.out.println(list.toString());
    }
}
