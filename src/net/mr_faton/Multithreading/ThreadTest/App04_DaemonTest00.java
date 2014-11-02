package net.mr_faton.Multithreading.ThreadTest;

/**
 * Created by root on 02.11.2014.
 */
public class App04_DaemonTest00 {
    public static void main(String[] args) {
        System.out.println("main демон? = " + Thread.currentThread().isDaemon());//говорит о том, что поток main - не демон

        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) ;
            }
        });
        newThread.setDaemon(false);
        newThread.start();

        System.out.println("main: Bye!");
    }
}
/*Хотя метод main завершается, но второй поток newThread продолжает работать в бесконечном цикле,
т.к. он не демон (newThread.setDaemon(false)), это свидетельствует о том, что и JVM тоже продолжает работать и наша
программа зависает в бесконечном цикле
 */