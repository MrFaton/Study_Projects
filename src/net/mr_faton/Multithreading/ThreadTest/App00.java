package net.mr_faton.Multithreading.ThreadTest;

import net.mr_faton.Multithreading.RunnableTest.RunnableImpl;

/**
 * Created by Faton on 30.10.2014.
 */
public class App00 {
    public static void main(String[] args) {
        Runnable r = new RunnableImpl();
        Thread newThread = new Thread(r);
        newThread.start();
    }
}
