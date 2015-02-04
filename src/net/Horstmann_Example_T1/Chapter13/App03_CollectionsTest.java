package net.Horstmann_Example_T1.Chapter13;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * Created by root on 04.02.2015.
 */
public class App03_CollectionsTest {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList = Arrays.asList("morning", "day", "night", "sun", "car", "home");
        print(arrayList, "basic");

        Collections.sort(arrayList);
        print(arrayList, "normal sort");

        int searchedElement = Collections.binarySearch(arrayList, "home");//проводить бинарный поиск можно только на отсортированной коллекции
        System.out.println("Index of element \"home\" is " + searchedElement + "\n");

        String maxElement = Collections.max(arrayList);//поиск макс или мин элемента нужно проводить на отсортированной коллекции
        System.out.println("maxElement: " + maxElement + "\n");

        System.out.println("minElement: " + Collections.min(arrayList) + "\n");

        Collections.sort(arrayList, Collections.reverseOrder());
        print(arrayList, "revers sort");

        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int difLength = str1.length() - str2.length();
                if (difLength != 0) {
                    return difLength;
                } else {
                    return str1.compareTo(str2);
                }
            }
        });
        print(arrayList, "manual sort");

        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int difLength = str1.length() - str2.length();
                if (difLength != 0) {
                    return difLength;
                } else {
                    return str1.compareTo(str2);
                }
            }
        }));
        print(arrayList, "manual revers sort");

        Collections.shuffle(arrayList);
        print(arrayList, "shuffle");

        List<String> subList = Collections.unmodifiableList(arrayList.subList(1, 3));
//        subList.add("ee");//Бросает исключение UnsupportedOperationException! Т.к. это не модифициремый список, его можно только читать
        print(subList, "subList");

        arrayList.set(2, "ttttt");
        print(subList, "with modification");

    }

    public static <E> void print(Collection<E> elements, String description) {
        System.out.println(elements.getClass().getSimpleName() + ": " + description);
        for (E element : elements) {
            System.out.println(element);
        }
        System.out.println();
    }
}
