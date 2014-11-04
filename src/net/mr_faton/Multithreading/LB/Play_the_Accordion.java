package net.mr_faton.Multithreading.LB;

/**
 * Created by root on 04.11.2014.
 */
public class Play_the_Accordion {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            //A&B
            Runnable printA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printA);
            threadA.start();
            Runnable printB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printB);
            threadB.start();
            threadA.join();
            threadB.join();
            //C
            System.out.println("-----");
            Runnable printC = new PrintRunnable("   C", 100);
            printC.run();
            System.out.println("-----");
        }
    }
}
