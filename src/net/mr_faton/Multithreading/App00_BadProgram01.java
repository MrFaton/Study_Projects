package net.mr_faton.Multithreading;

/**
 * Created by root on 29.10.2014.
 */
public class App00_BadProgram01 {
    public static final int N = 10_000_000;
    public static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < N; k++) counter++;
            }
        });
        t0.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < N; k++) counter++;
            }
        });
        t1.start();

        t0.join();//это присоединиться и подождать покапоток закончит свою работу.
        t1.join();

        System.out.println(counter);
    }
}