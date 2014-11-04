package net.mr_faton.Multithreading.LB;

/**
 * Created by root on 04.11.2014.
 */
public class Play_the_Accordion_Done {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Хозяин заставил прораба выполнить всю работу и ждёт...");
        Thread prorabThread = new Thread(new ProrabRunnable());
        prorabThread.start();
        prorabThread.join();
        System.out.println("Хозяин закончил ждать и закончил ремонт");
    }
}
