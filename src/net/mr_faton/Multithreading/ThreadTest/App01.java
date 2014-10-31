package net.mr_faton.Multithreading.ThreadTest;

/**
 * Created by Faton on 30.10.2014.
 */
public class App01 {
    public static void main(String[] args) {
        System.out.println("Мы в потоке метода main(), имя потока: " + Thread.currentThread().getName());

        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run(). Мы в новом потоке newThread, его имя: " + Thread.currentThread().getName());
            }
        });
        newThread.start();
    }
}
