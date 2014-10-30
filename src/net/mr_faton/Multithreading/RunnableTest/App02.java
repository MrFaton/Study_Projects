package net.mr_faton.Multithreading.RunnableTest;

/**
 * Created by Faton on 30.10.2014.
 */
public class App02 {
    public static void main(String[] args) {
        Runnable r0 = new Runnable() {
            public void run() {
                System.out.println("run()");
            }
        };

        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("run()");
            }
        };

        r0.run();
        r1.run();

        System.out.println("Имя первого анонимного класса, которое создал компилятор: " + r0.getClass().getName());
        System.out.println("Имя второго анонимного класса, которое создал компилятор: " + r1.getClass().getName());
    }
}
/*Когда компилятор не понял, что это должен быть один и тот же анонимный класс, т.к. оба анонимных классов выполняют
одну и ту же функцию
*/