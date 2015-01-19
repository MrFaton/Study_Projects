package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App05 {
    public static /*synchronized*/ void main(String[] args) throws InterruptedException {
        synchronized (App05.class) {
            App05.class.wait(2000);
        }
    }
}
//Всё работает, т.к. мы синхронизировались по конкретному объекту. Можно метод main синхронизировать, а можно и нет.