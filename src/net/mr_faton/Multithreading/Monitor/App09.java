package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App09 {
    public static void main(String[] args) throws InterruptedException {
        Object ref = new Object();
        synchronized (ref) {
            synchronized (ref) {
                synchronized (ref) {
                    //reentrant lock
                    ref.notify();
                }
            }
        }
    }
}
//тут ничего нового не произойдёт, хоть 1 раз синхронизировались по ref, хоть 3 раза.