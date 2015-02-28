package net.Horstmann_Example_T1.Chapter14.App02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

/**
 * Created by Mr_Faton on 28.02.2015.
 */
public class Handler implements Runnable {
    private BlockingQueue<Integer> queue;
    private int needNum;
    private ExecutorService threadPool;

    public Handler(BlockingQueue<Integer> queue, int needNum, ExecutorService threadPool) {
        this.queue = queue;
        this.needNum = needNum;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int i = queue.take();
                System.out.println("take: " + i);
                if (i == 6) {
                    queue.put(i);
                    System.out.println("got the number!");
                    threadPool.shutdown();
                    break;
                } else {
                    threadPool.submit(new Little(i));
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private class Little implements Runnable {
        private int need;

        private Little(int need) {
            this.need = need;
        }
        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(2000);
                System.out.println("produce it " + need);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
