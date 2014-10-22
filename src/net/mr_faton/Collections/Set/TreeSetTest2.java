package net.mr_faton.Collections.Set;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Faton on 22.10.2014.
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<>(new StrComparator1());//тут наследуемся от интерфейса NavigableSet, в нём больше методов чем у Set
        set.add("b");
        set.add("e");
        set.add("a");
        set.add("c");
        set.add("f");
        set.add("d");
        System.out.println("Как выглядит внутри TreeSet: " + set);

        System.out.println("Первый элемент из списка: " + set.pollFirst());
        System.out.println("Последний элемент из списка: " + set.pollLast());

        NavigableSet<String> strSubSet = set.subSet("b", true, "e", false);//берём подстроку от символа "b" включая его и до символа "е" не включая его
        System.out.println("Подможество от b включая b и до е не включая е: " + strSubSet);
    }
}

class StrComparator1 implements Comparator<String> {

    @Override
    public int compare(String str0, String str1) {
        int lenDif = str0.length() - str1.length();
        if (lenDif != 0) {
            return lenDif;
        } else {
            return str0.compareTo(str1);
        }
    }
}