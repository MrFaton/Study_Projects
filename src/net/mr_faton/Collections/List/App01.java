package net.mr_faton.Collections.List;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by root on 01.10.2014.
 */
public class App01 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
//        System.out.println(list.get(1));// НЕ работает, потому что в Collection нет такого метода, а вот в List и соответственно в ArrayList есть.
    }
}
