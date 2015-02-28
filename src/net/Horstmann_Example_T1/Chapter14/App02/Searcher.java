package net.Horstmann_Example_T1.Chapter14.App02;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Mr_Faton on 28.02.2015.
 */
public class Searcher implements Runnable {
    private BlockingQueue<Integer> queue;
    private int[] arr;

    public Searcher(BlockingQueue<Integer> queue, int[] arr) {
        this.queue = queue;
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i : arr) {
            try {
                queue.put(i);
                System.out.println("put: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
