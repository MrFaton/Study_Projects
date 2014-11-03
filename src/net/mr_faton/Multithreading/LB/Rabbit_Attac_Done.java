package net.mr_faton.Multithreading.LB;

/**
 * Created by Faton on 03.11.2014.
 */
public class Rabbit_Attac_Done {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            Runnable printer = new PrintRunnable_Done(i);
            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(100);
        }
    }
}
