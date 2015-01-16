package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App03 {
    public static synchronized void main(String[] args) throws InterruptedException {
        Object ref = new Object();
        ref.wait();
//        ref.notify();
//        ref.notifyAll();
    }
}
//Если синхронизировать метод, а не секцию, то работать не будет.