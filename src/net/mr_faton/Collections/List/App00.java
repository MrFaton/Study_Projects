package net.mr_faton.Collections.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 01.10.2014.
 */
public class App00 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("1 " + list);
        System.out.println("2 " + list.get(1));
        System.out.println("3 " + list.contains("x"));
        System.out.println("4 " + list.contains("b"));
        System.out.println("5 " + list.remove("b"));
        System.out.println("6 " + list.remove("xxxxx"));
        System.out.println("7 " + list);
        System.out.println("8 " + list.remove(0));
        System.out.println("9 " + list);
        list.clear();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("10 " + list);

        System.out.println("11 " + list.set(1, "xxxx"));//возвращает того кто был на этой позиции и одновременно записывает в эту позицию новое значение
        System.out.println("12 " + list);

        list.add(0, "ccc");//вставляет значение в позицию, а остальные значения справа подвигает на одну позицию в право
        System.out.println("13 " + list);
    }
}
