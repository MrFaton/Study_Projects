package net.Horstmann_Example_T1.Chapter14.App02_ThreadPool_With_Callable;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by root on 04.02.2015.
 */
public class TextMatcher {
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
        final BlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        threadPool = Executors.newFixedThreadPool(NUM_OF_HANDLE_THREADS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new FileSearcher(directoryPath, queue).call();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new FileHandler(keyWord, queue, threadPool).call();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
/*
Все эти классы, такие же точно как и в пакете App01_BlockingQueue_and_ThreadPool, только тут они расширяют
интерфейс Callable. Он вроде бы лучше, так как у него есть метод call, который может возвращать значения и кадать
исключание в отличае от run.
 */