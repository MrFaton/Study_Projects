package net.Horstmann_Example_T1.Chapter14.App01_BlockingQueue_and_ThreadPool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by root on 04.02.2015.
 */
public class FileHandler implements Runnable {
    private BlockingQueue<File> queue;
    private final String keyWord;
    private final ExecutorService threadPool;
    private int maxCountOfThreads = 0;

    public FileHandler(String keyWord, BlockingQueue<File> queue, final ExecutorService threadPool) {
        if (keyWord.length() == 0 | keyWord == null) {
            String exStr = "Неверное ключевое слово: " + keyWord;
            throw new IllegalArgumentException(exStr);
        }
        this.keyWord = keyWord;
        this.queue = queue;
        this.threadPool = threadPool;
    }

    public void run() {
        while (true) {
            File currentFile;
            try {
                currentFile = queue.take();
            } catch (InterruptedException e) {
                break;
            }
            if (currentFile != FileSearcher.STOP_WORK) {
                threadPool.submit(new Worker(currentFile));
                maxCountOfThreads = Math.max(((ThreadPoolExecutor)threadPool).getPoolSize(), maxCountOfThreads);
            } else {
                try {
                    queue.put(currentFile);
                } catch (InterruptedException e) {
                    break;
                }
                threadPool.shutdown();
                System.out.println("Максимально колличество потоков во время работы: " + maxCountOfThreads);
                break;
            }
        }
    }

    private class Worker implements Runnable {
        private Scanner in;
        private File file;

        private Worker(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            try {
                in = new Scanner(file);
                int lineNumber = 0;
                while (in.hasNext()) {
                    lineNumber++;
                    String line = in.nextLine();
                    if (line.contains(keyWord)) {
                        System.out.println("Искомое слово найдено в файле: " + file.getPath() + ", в строке: " +
                                lineNumber + ", строка: " + line.trim());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
//Класс, который берёт из очереди файл и ощет в нём ключевое слово