package net.mr_faton.OOP.App16_Singleton.SingletonEarly_Pac;

/**
 * Created by root on 02.12.2014.
 */
public class SingletonEarly_itsProblem {
    public static int k = 1_990;
    public static final SingletonEarly_itsProblem instance = new SingletonEarly_itsProblem();

    private SingletonEarly_itsProblem() {
        System.out.println("SingletonEarly_itsProblem is created...");
    }
}

class Test_itsProblem {
    public static void main(String[] args) {
        System.out.println("Просто вызваем статичекое поел k");
        System.out.println(SingletonEarly_itsProblem.k);
        System.out.println("а теперь вызовем конструктор:");
        SingletonEarly_itsProblem ref = SingletonEarly_itsProblem.instance;
    }
}
/*
Даже когда мы просто пользуемся полем класса SingletonEarly_itsProblem, то всё равно отрабатывает его конструктор и
мы получаем экземпляр этого класса, хотя нам нужно было только статическое поле.
 */