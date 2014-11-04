package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App01 {
    public static void main(String[] args) throws InterruptedException {
        Object ref = new Object();
        ref.wait();
//        ref.notify();
//        ref.notifyAll();
    }
}
// В любом из трёх случаев программа работать не будет, она просто выкинет исключение IllegalMonitorStateException