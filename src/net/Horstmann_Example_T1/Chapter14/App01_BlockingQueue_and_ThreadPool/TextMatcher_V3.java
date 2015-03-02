package net.Horstmann_Example_T1.Chapter14.App01_BlockingQueue_and_ThreadPool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by root on 04.02.2015.
 */
public class TextMatcher_V3 {
    //размер блокирующей очереди
    private static final int QUEUE_SIZE = 10;
    //колличество потоков, которые обрабатывают элементы из очереди
    private static final int NUM_OF_HANDLE_THREADS = 20;
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
        //создаём пул при помощи метода-фабрики newCachedThreadPool
        threadPool = Executors.newCachedThreadPool();

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
/*
Принци работы этого класса не отличается от остальных версий.
Единственное отличие - это тип созданного пула потоков.
Тут пул реализован при помощи метода-фабрики newCachedThreadPool. Как он работает?
Пулл создает потоки по мере необходимости, но переиспользует неактивные потоки (и подчищает потоки, которые были
неактивные некоторое время).

На этой задаче этот класс показал максимальное время работы.
 */