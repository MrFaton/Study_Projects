package net.Horstmann_Example_T1.Chapter14.App02_ThreadPool_With_Callable;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/**
 * Created by Mr_Faton on 01.03.2015.
 */
public class FileHandler implements Callable {
    private BlockingQueue<File> queue;
    private final String keyWord;
    private final ExecutorService threadPool;

    public FileHandler(String keyWord, BlockingQueue<File> queue, final ExecutorService threadPool) {
        if (keyWord.length() == 0 | keyWord == null) {
            String exStr = "Неверное ключевое слово: " + keyWord;
            throw new IllegalArgumentException(exStr);
        }
        this.keyWord = keyWord;
        this.queue = queue;
        this.threadPool = threadPool;
    }

    @Override
    public Object call() throws InterruptedException {
        while (true) {
            File currentFile = queue.take();
            if (currentFile != FileSearcher.STOP_WORK) {
                threadPool.submit(new Worker(currentFile));
            } else {
                queue.put(currentFile);
                threadPool.shutdown();
                break;
            }
        }
        return null;
    }

    private class Worker implements Callable {
        private Scanner in;
        private File file;

        private Worker(File file) {
            this.file = file;
        }

        @Override
        /*
        тут в качестве возвращаемого значения испльзуется класс Void! Это говорит о том, что не надо ждать
        возвращаемых результатов
         */
        public Void call() throws Exception {
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
            return null;
        }
    }
}
