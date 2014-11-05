package net.mr_faton.Multithreading.Monitor;

/**
 * Created by root on 04.11.2014.
 */
public class App08 {
    public static /*synchronized*/ void main(String[] args) throws InterruptedException {
        /*synchronized (App08.class) {*/
        App08.class.wait(2000);
        /*}*/
    }
}
//Но если в сигнатуре статичкского метода убрать synchronized и убрать синхронизированную секцию, то работать не будет