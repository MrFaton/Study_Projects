package net.Horstmann_Example_T1.Chapter14.App01_BlockingQueue_and_ThreadPool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by root on 04.02.2015.
 */
public class TextMatcher_V2 {
    //размер блокирующей очереди
    private static final int QUEUE_SIZE = 10;
    //колличество потоков, которые обрабатывают элементы из очереди
    private static final int NUM_OF_HANDLE_THREADS = 4;
    //путь к папке, в которой будем искать файлы в корне и во всех подпапках
    private static File directoryPath;
    //ключевое слово, которое нужно найти
    private static String keyWord;
    private static ExecutorService threadPool;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ввести путь к папке (например: X:\\Faton\\Java):");
        directoryPath = new File(in.nextLine());
        System.out.println("Ключевое слово (например: volatile):");
        keyWord = in.nextLine();

        //создаём объект блокирующей очереди ArrayBlockingQueue типа BlockingQueue
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        threadPool = Executors.newFixedThreadPool(NUM_OF_HANDLE_THREADS);

        long workTime = System.currentTimeMillis();
        new Thread(new FileSearcher(directoryPath, queue)).start();
        Thread handle = new Thread(new FileHandler(keyWord, queue, threadPool));
        handle.start();
        try {
            handle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workTime = System.currentTimeMillis() - workTime;
        System.out.println("Работа завершена за: " + workTime);
    }
}
