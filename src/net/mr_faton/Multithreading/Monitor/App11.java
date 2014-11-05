package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App11 {
    public static void main(String[] args) throws InterruptedException {
        Object ref0 = new Object();
        Object ref1 = new Object();
        synchronized (ref0) {
            synchronized (ref1) {
                ref1.notify();
                ref0.notifyAll();
                ref0.notifyAll();
                ref1.notify();
            }
        }
    }
}
/*Можно синхронизироваться в любом порядке многократно и по разным объектам, вызывая у них потом в любом порядке
методы wait(), notify(), notifyAll()
 */