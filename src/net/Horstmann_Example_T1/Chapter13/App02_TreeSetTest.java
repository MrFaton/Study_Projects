package net.Horstmann_Example_T1.Chapter13;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * Created by Mr_Faton on 31.01.2015.
 */
public class App02_TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> products = new TreeSet<>();
        products.add(new Item("Toaster", 5426));
        products.add(new Item("Monitor", 5483));
        products.add(new Item("Modem", 5834));
        products.add(new Item("Keyboard", 5289));

        System.out.println("Стандартная сортировка по номеру изделия: ");
        for (Item element : products) {
            System.out.println(element);
        }

        /*
        Не стандартная сортировка. По стандарту у нас сортируется по номеру изделия, но мы хотим, чтобы сортировалось
        по описанию. Для этого мы реализуем класс, который имплементит интерфейс Comparator и реализовыввем в нём
        метод compare. Можно сделать анонимный внутренний класс, который реализует Comparator: new Compare() {...}.
        Сортируется так: сначала короткие строки, потом длинные. Елси длины строк совпали, то стороки сортируются между
        собой в лексикографическом порядке.
         */
        SortedSet<Item> descriptionSort = new TreeSet<>(new Comparator<Item>() {
            public int compare(Item firstItem, Item secondItem) {
                String firstDescription = firstItem.getDescription();
                String secondDescription = secondItem.getDescription();
                //определили строки имеют одинаковую длину или нет
                int difLength = firstDescription.length() - secondDescription.length();
                if (difLength == 0) {
                    //если однинаковая длина - сортируем в лексикографическом порядке
                    return firstDescription.compareTo(secondDescription);
                } else {
                    //если разная длина - сортируем короткая строка первая
                    return difLength;
                }
            }
        });

        //добавляем все элементы из основной коллекции в новую, которая испльзует новый коспаратор (новый принцип сортировки)
        descriptionSort.addAll(products);
        System.out.println("\nСортировка по описанию изделия: ");
        for (Item element : descriptionSort) {
            System.out.println(element);
        }
    }
}

class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[description: " + description + ", partNumber: " + partNumber + "]";
    }

    //стандартная сортировка по номеру изделия
    public int compareTo(Item otherItem) {
        return partNumber - otherItem.partNumber;
//        return Integer.compare(partNumber, otherItem.partNumber);//или можно было так сделать
    }
}

/*
Деревянное множество или TreeSet, это почти такое же множество как и HashSet, с тем отличием, что все элементы
хранятся в отсортированном виде. Для хранения НЕ используется хэш-таблица, тут для сортировки используется дерево.
Если выводить элементы, то они будут выводиться в отсортированном виде.
 */