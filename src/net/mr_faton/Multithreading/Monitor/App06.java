package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App06 {
    public static synchronized void main(String[] args) throws InterruptedException {
        App06.class.wait(2000);
    }
}
//Так тоже всё работает