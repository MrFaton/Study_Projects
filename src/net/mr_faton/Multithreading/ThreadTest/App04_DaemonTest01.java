package net.mr_faton.Multithreading.ThreadTest;

/**
 * Created by root on 02.11.2014.
 */
public class App04_DaemonTest01 {
    public static void main(String[] args) {
        System.out.println("main демон? = " + Thread.currentThread().isDaemon());//говорит о том, что поток main - не демон

        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) ;
            }
        });
        newThread.setDaemon(true);
        newThread.start();

        System.out.println("main: Bye!");
    }
}
/*Так как второй поток демон, то JVM завершается сразу после того, как завершился метод main, т.е., по
завершению главного потока программа завершается, прибивая все незавершившиеся потоки, помеченные как демоны.
 */