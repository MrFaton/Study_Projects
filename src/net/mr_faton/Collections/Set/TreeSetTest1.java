package net.mr_faton.Collections.Set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Faton on 22.10.2014.
 */
public class TreeSetTest1 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(new StrComparator()); //передаём сюда класс в котором реализован compare с тем способом сортировки, который нам нужен
        set.add("a");
        set.add("ay");
        set.add("b");
        set.add("ax");
        System.out.println("Как выглядит внутри TreeSet: " + set);

//Суть отсорттированных списко не только что их можно выводить в отсортированно порядке, но и перебирать их в отсортированном порядке
        Iterator<String> iter = set.iterator();
        System.out.println("Берём первый элемент из списка: " + iter.next());
        System.out.println("Берём второй элемент из списка: " + iter.next());
    }
}

class StrComparator implements Comparator<String> { //создаём класс, который имплементит Comparator и реализовывает метод compare, в котором содержится правило сортировки

    @Override
    public int compare(String str0, String str1) {
        int lenDif = str0.length() - str1.length(); //сравниваем длину двух строк
        if (lenDif != 0) {
            return lenDif; //если число положительное, значит первоя строка длинее второй, если отринцательное первая строка короче второй
        } else {
            return str0.compareTo(str1); //если строки одинаковой длин, то запускаем оригинальный метод compareTo, который реализован в классе String и строки с одинаковой длиной отсортруются между собой в лексикографическом порядке
        }
    }
}