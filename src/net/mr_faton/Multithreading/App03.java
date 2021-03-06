package net.mr_faton.Multithreading;

/**
 * Created by root on 06.11.2014.
 */
public class App03 {
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

    public static void hello(int id) {
        System.out.println("Поток с номером " + id + " вошёл в метод hello");
        synchronized (App03.class) {
            System.out.println("Поток с номером " + id + " вошёл в синхронизированную секцию");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) {/*NOP*/}
        }
        System.out.println("Поток с номером " + id + " вышел из синхронизированной секции");
    }
}
//Пример с синхронизированной секцией