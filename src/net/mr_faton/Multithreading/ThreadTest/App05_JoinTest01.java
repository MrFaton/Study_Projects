package net.mr_faton.Multithreading.ThreadTest;

/**
 * Created by root on 02.11.2014.
 */
public class App05_JoinTest01 {
    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sillyWork();
                    System.out.println("Hello!");
                }
            }
        });
        newThread.start();

        for (int i = 0; i < 3; i++) {
            sillyWork();
            System.out.println("Bye!");
        }

        newThread.join();
        System.out.println("That's ALL!");
    }

    public static void sillyWork() {
        double d = 2.0;
        for (int k = 0; k < 10_000_000; k++) {
            d = Math.sin(d);
        }
    }
}
