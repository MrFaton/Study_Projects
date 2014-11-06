package net.mr_faton.Multithreading.Monitor.BlockingQueueTest;

/**
 * Created by Faton on 05.11.2014.
 */
public class Consumer implements Runnable {
    private final SingleElementBuffer buffer;
    private final int id;

    public Consumer(SingleElementBuffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer elem = buffer.get();
                System.out.println(System.currentTimeMillis() + ": " + elem + " было употреблено " + id);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " был остановлен");
                return;
            }
        }
    }
}
