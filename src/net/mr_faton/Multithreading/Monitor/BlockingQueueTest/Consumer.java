package net.mr_faton.Multithreading.Monitor.BlockingQueueTest;

/**
 * Created by Faton on 05.11.2014.
 */
public class Consumer implements Runnable {
    private final SingleElementBuffer buffer;

    public Consumer(SingleElementBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer elem = buffer.get();
                System.out.println(elem + " был употреблён");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " был остановлен");
                return;
            }
        }
    }
}
