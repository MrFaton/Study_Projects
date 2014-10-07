package net.mr_faton.Collections;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by Faton on 07.10.2014.
 */
public class App00 {
    public static void main(String[] args) {
        List<String> listArrayList = new ArrayList<>(asList("A", "B", "C"));
        List<String> listLinkedList = new LinkedList<>(asList("D", "E", "F"));
        Set<String> listHashSet = new HashSet<>(asList("G", "H", "I"));

        Map<String, String> map = new HashMap<>();
        map.put("A", "*");
        map.put("B", "+");
        map.put("C", "-");

        firstWay(listArrayList);
        firstWay(listLinkedList);

        secondWay(listArrayList);
        secondWay(listLinkedList);

        thirdWay(listArrayList);
        thirdWay(listLinkedList);

        fourthWay(listArrayList);
        fourthWay(listLinkedList);
        fourthWay(listHashSet);

        fifthWay(listArrayList);
        fifthWay(listLinkedList);
        fifthWay(listHashSet);

        sixthWay(listArrayList);
        sixthWay(listLinkedList);
        sixthWay(listHashSet);

        getingMap(map);
    }

    public static void firstWay(List list) {
        System.out.println("Первый способ:");
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k));
        }
        System.out.println("*******");
    }
    //Первый способ хорош для ArrayList, но очень плох для LinkedList, тем более что такой метод может работать только с List, не потому что указано в типе метода, а потому что у List есть последовательность и упорядоченность элементов

    public static void secondWay(List list) {
        System.out.println("Второй способ:");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("*******");
    }
    //Второй способ уже хорош и для ArrayList и для LinkedList, особенно в LinkedList он работает очень быстро

    public static void thirdWay(List list) {
        System.out.println("Третий способ:");
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
        System.out.println("*******");
    }
    //Третий способ тоже самой что и второй, только более короткий, в одну строчку

    public static void fourthWay(Collection list) {
        System.out.println("Четвёртый способ:");
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
        System.out.println("*******");
    }
    //Четвёртый способ даёт возможность перебрать элементы не только от List, но и Set, так как все они имплементят интерфейс Iterator

    public static void fifthWay(Collection<String> list) {
        System.out.println("Пятый способ:");
        for (String elem : list) {
            System.out.println(elem);
        }
        System.out.println("*******");
    }
    //Тот же самы цикл что и выше, только с помощью нового for, который иногда просто называют for each, более того, этот способ принемает только коллекции типа стринг Collection<String>

    public static void sixthWay(Collection list) {
        System.out.println("Шестой способ:");
        for (Object elem : list) {
            System.out.println(elem);
        }
        System.out.println("*******");
    }
    //Тот же способ что и пятый, но только теперь метод принемает не только колекции типа String, а и любые другие, например Integer, Double

    public static void getingMap(Map<String, String> map) {
        System.out.println("Вывести Мапу:");
        for (Map.Entry<String, String> elem : map.entrySet()) {
            System.out.println(elem);
        }
        System.out.println("*******");
    }
}
