package net.Horstmann_Example_T1.Chapter14.App01;

import net.Horstmann_Example_T1.Chapter14.App00_BlockinQueue.FileHandler;
import net.Horstmann_Example_T1.Chapter14.App00_BlockinQueue.FileSearcher;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by root on 04.02.2015.
 */
public class Block {
    //размер блокирующей очереди
    private static final int QUEUE_SIZE = 10;
    //колличество потоков, которые обрабатывают элементы из очереди
    private static final int NUM_OF_HANDLE_THREADS = 20;
    //путь к папке, в которой будем искать файлы в корне и во всех подпапках
    private static File directoryPath;
    //ключевое слово, которое нужно найти
    private static String keyWord;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ввести путь к папке (например: X:\\Faton\\Java):");
        directoryPath = new File(in.nextLine());
        System.out.println("Ключевое слово (например: volatile):");
        keyWord = in.nextLine();

        //создаём объект блокирующей очереди ArrayBlockingQueue типа BlockingQueue
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

        //создаём экземпляр класса FileSearcher, в котором организован поиск всех файлов и забивание их в очередь
        net.Horstmann_Example_T1.Chapter14.App00_BlockinQueue.FileSearcher searcher = new FileSearcher(directoryPath, queue);
        //создаём и запускаем новый поток, который ищет и забивает в очередь файлы
        Thread searchFileThread = new Thread(searcher);
        searchFileThread.start();
        new Thread(new FileHandler(keyWord, queue)).start();

    }
}
