package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App00 {
    public static void main(String[] args) throws InterruptedException {
        new Object().wait();
//        new Object().notify();
//        new Object().notifyAll();
    }
}
// В любом из трёх случаев программа работать не будет, она просто выкинет исключение IllegalMonitorStateException