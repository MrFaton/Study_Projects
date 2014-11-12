package net.mr_faton.Multithreading.KillThread;

/**
 * Created by Faton on 10.11.2014.
 */
public class App00_destroy {
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
        Thread.sleep(1000);
        System.out.println("Пробуем остановить");
        thread.destroy();
    }
}
