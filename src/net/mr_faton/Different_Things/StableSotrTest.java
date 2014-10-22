package net.mr_faton.Different_Things;

import java.util.*;

/**
 * Created by Faton on 22.10.2014.
 */
public class StableSotrTest {
    public static void main(String[] args) {
        List<Point2DTest> list = new ArrayList<>();
        list.add(new Point2DTest("Blaster", 41));
        list.add(new Point2DTest("Alpina", 80));
        list.add(new Point2DTest("Alpina", 46));
        list.add(new Point2DTest("Blaster", 11));
        //***********************************************************************
        System.out.println("Изначальный список:");
        for (Point2DTest item : list) {
            System.out.println(item);
        }
        //***********************************************************************

        Collections.sort(list, new Comparator<Point2DTest>() {
            @Override
            public int compare(Point2DTest o1, Point2DTest o2) {
                String str1 = o1.getName();
                String str2 = o2.getName();
                return str1.compareTo(str2);
            }
        });
        System.out.println("Отсортированный по имени:");
        for (Point2DTest item : list) {
            System.out.println(item);
        }
        //***********************************************************************

        Collections.sort(list, new Comparator<Point2DTest>() {
            @Override
            public int compare(Point2DTest o1, Point2DTest o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        System.out.println("Отсортированный по цене:");
        for (Point2DTest item : list) {
            System.out.println(item);
        }
        //***********************************************************************

        Collections.sort(list, new Comparator<Point2DTest>() {
            @Override
            public int compare(Point2DTest o1, Point2DTest o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        Collections.sort(list, new Comparator<Point2DTest>() {
            @Override
            public int compare(Point2DTest o1, Point2DTest o2) {
                String str1 = o1.getName();
                String str2 = o2.getName();
                return str1.compareTo(str2);
            }
        });
        System.out.println("Отсортированный снача по имени, а внутри имени по цене:");
        for (Point2DTest item : list) {
            System.out.println(item);
        }


    }
}

class Point2DTest {
    private final String name;
    private final int price;

    Point2DTest(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Point2DTest{" +
                "Название='" + name + '\'' +
                ", цена=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Point2DTest anotherExemplar = (Point2DTest) obj;
        return this.getName() == anotherExemplar.getName() && this.getPrice() == anotherExemplar.getPrice();
    }

    @Override
    public int hashCode() {
        return 31 * price + name.length();
    }
}

/* этот пример иллюстрирует то, что сортировка из JDK, а именно метод sort - стабильный, это видно из того последнего
варианта сортировки, когда мы сначала отсортировали по цене, а потом отсортировали по имени, если бы элементы переставлялись
местами, мы бы не получили готового результата в последнем случае, такого как отсортированного по имени, а объекты с
одинаковым именнем отсортированны по цене
 */