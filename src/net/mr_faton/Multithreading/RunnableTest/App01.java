package net.mr_faton.Multithreading.RunnableTest;

/**
 * Created by Faton on 30.10.2014.
 */
public class App01 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("run()");
            }
        };

        r.run();

        System.out.println("Имя анонимного класса, которое создал компилятор: " + r.getClass().getName());
    }
}
