package net.mr_faton.Multithreading.KillThread;

/**
 * Created by Faton on 10.11.2014.
 */
public class App02_susperd_resume {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello!");
                    double d = 2;
                    for (int k = 0; k < 10_000_000; k++) {
                        d = Math.sin(d);
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        System.out.println("Приостанавливаем поток");
        thread.suspend();
        Thread.sleep(3000);
        System.out.println("Возобновляем поток");
        thread.resume();
    }
}
