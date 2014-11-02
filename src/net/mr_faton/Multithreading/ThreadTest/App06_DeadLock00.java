package net.mr_faton.Multithreading.ThreadTest;

/**
 * Created by root on 02.11.2014.
 */
public class App06_DeadLock00 {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
    }
}
//Такая программа зависает в бесконечном ожидании, т.к. я присоединяюсь сам к себе.