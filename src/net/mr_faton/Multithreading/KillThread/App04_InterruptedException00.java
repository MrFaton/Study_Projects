package net.mr_faton.Multithreading.KillThread;

/**
 * Created by Faton on 10.11.2014.
 */
public class App04_InterruptedException00 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Thread myThread = Thread.currentThread();
                    System.out.println(myThread.isInterrupted());
                    try {
                        Thread.sleep(1_000_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("Отослали сообщение об самоуничтожении");
        thread.interrupt();
    }
}
