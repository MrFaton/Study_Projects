package net.mr_faton.Multithreading.ThreadTest;

/**
 * Created by Faton on 30.10.2014.
 */
public class App02 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i<5; i++){
            Thread.sleep(500);
            System.out.println("Hello");
        }
    }
}
