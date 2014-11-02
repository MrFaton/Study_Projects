package net.mr_faton.Multithreading.ThreadTest;

/**
 * Created by root on 02.11.2014.
 */
public class App06_DeadLock01_Classic {
    public static void main(String[] args) throws InterruptedException {
        final Thread[] threads = new Thread[2];
        threads[0] = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("#0 join to #1");
                try {
                    threads[1].join();
                } catch (InterruptedException e) {
                    //nothing
                }
            }
        });

        threads[1] = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("#1 join to #0");
                try {
                    threads[0].join();
                } catch (InterruptedException e) {
                    //nothing
                }
            }
        });

        threads[0].start();
        threads[1].start();
    }
}
//Поток №0 ожидает пока помрёт поток №1, а поток №1 ожидает пока помрёт поток №0 и это всё равно бесконечность