package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App07 {
    public static /*synchronized*/ void main(String[] args) throws InterruptedException {
        synchronized (App07.class) {
            App07.class.wait(2000);
        }
    }
}
//И так тоже всё будет работать.