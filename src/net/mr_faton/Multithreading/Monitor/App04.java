package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App04 {
    public static void main(String[] args) throws InterruptedException {
        synchronized (new Object()) {
            new Object().wait();
        }
    }
}
/*Падаем по исключению IllegalMonitorStateException, т.к. в секции мы засинхронизировались по одному объекту, а вызываем
wait() у другого объекта.
*/