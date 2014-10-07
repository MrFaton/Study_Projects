package net.mr_faton.Different_Things;

/**
 * Created by Faton on 03.10.2014.
 */
public class GenericsExample {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Nice", 20);
        System.out.println(pair1.first);
        System.out.println(pair1.second);
        System.out.println("***");

        Pair<Integer, Double> pair2 = new Pair<>(15, 10.4);
        System.out.println(pair2.first);
        System.out.println(pair2.second);
        System.out.println("***");
    }
}

class Pair<A, B> {
    public final A first;
    public final B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}
//Пример испльзования дженериков на классе с парой неопределённых типов