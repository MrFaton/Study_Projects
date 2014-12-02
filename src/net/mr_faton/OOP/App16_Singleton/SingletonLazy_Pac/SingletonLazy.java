package net.mr_faton.OOP.App16_Singleton.SingletonLazy_Pac;

/**
 * Created by root on 02.12.2014.
 */
public class SingletonLazy {
    public static int f = 25;
    private static SingletonLazy instance;

    private SingletonLazy() {
        System.out.println("SingletonLazy is created...");
    }

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("Просто вызваем статичекое поел f");
        System.out.println(SingletonLazy.f);
        System.out.println("а теперь вызовем конструктор:");
        SingletonLazy.getInstance();
    }
}
/*
Как видим когда мы просто читаем поле, то наш конструктор не вызвается, он вызвался только тогда, когда мы вызвали
метод его создания его экземпляра - getInstance.
А в пером случае (SingletonEarly, SingletonEarly_itsProblem) - констуктор вызывается сразу как только мы пытаемся
читать поле.
 */