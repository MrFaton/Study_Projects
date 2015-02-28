package net.Horstmann_Example_T1.Chapter14.App01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by root on 28.02.2015.
 */
public class FileHandler implements Runnable {
    private BlockingQueue<File> queue;
    private String keyWord;
    private ExecutorService threadPool;
    private boolean done = false;

    public FileHandler(BlockingQueue<File> queue, String keyWord) {
        this.queue = queue;
        this.keyWord = keyWord;
        threadPool = new ThreadPoolExecutor(4, 64, 3L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50));
    }

    private void processFile(File file) {
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineNumber = 0;
        while (in.hasNext()) {
            lineNumber++;
            String line = in.nextLine();
            if (line.contains(keyWord)) {
                System.out.println("Искомое слово найдено в файле: " + file.getPath() + ", в строке: " + lineNumber + ", строка: " + line);
            }
        }
    }

    @Override
    public void run() {
        try {
            while (! done) {
                File file = queue.take();
                if (file == FileSearcher.STOP_WORK) {
                    System.out.println("Обработчик: наши файл остановки...");
                    queue.put(file);
                    System.out.println("Обработчик: бросил файл остановки назад в очередь...");
                    done = true;
                } else {
                    threadPool.submit(new Runnable() {
                        @Override
                        public void run() {
                            processFile(file);
                        }
                    });
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
