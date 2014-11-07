package net.mr_faton.Multithreading;

/**
 * Created by root on 06.11.2014.
 */
public class App04 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello(1);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello(2);
            }
        });

        thread1.start();
        thread2.start();
    }

    public synchronized static void hello(int id) {
        System.out.println("Поток с номером " + id + " вошёл в синхронизированный метод");
        try {
            App04.class.wait(3000);
        } catch (InterruptedException ignore) {/*NOP*/}
        System.out.println("Поток с номером " + id + " вышел из синхронизированного метода");
    }
}
//Пример кода, когда в синхронизированный метод могут попать одновременно 2 потока! Это единственный случай!