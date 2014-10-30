package net.mr_faton.Multithreading.RunnableTest;

/**
 * Created by Faton on 30.10.2014.
 */
public class App00 {
    public static void main(String[] args) {
        Runnable r0 = new RunnableImpl();
        Runnable r1 = new RunnableImpl();

        r0.run();
        r1.run();

        System.out.println("Имя класса: "+r0.getClass().getName());//Можно посмотреть имя класса
    }
}
