package net.Horstmann_Example_T1.Chapter14.App02;

import java.util.concurrent.*;

/**
 * Created by Mr_Faton on 28.02.2015.
 */
public class Tester {
    private static BlockingQueue<Integer> queue;
    public static void main(String[] args) {
        queue = new ArrayBlockingQueue<Integer>(5);
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 6, 13, 15};
        ExecutorService threadPool = new ThreadPoolExecutor(4, 10, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        new Thread(new Searcher(queue, arr)).start();
        new Thread(new Handler(queue, 4, threadPool)).start();
    }
}
