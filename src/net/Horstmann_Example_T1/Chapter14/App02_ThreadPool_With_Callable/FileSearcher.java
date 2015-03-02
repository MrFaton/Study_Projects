package net.Horstmann_Example_T1.Chapter14.App02_ThreadPool_With_Callable;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Created by Mr_Faton on 01.03.2015.
 */
public class FileSearcher implements Callable {
    private BlockingQueue<File> queue;
    private File directoryPath;
    public static final File STOP_WORK = new File("STOP");

    public FileSearcher(File directoryPath, BlockingQueue<File> queue) {
        if (directoryPath == null) {
            String exStr = "Передан пустой аргумент... Путь к файлу: " + directoryPath;
            throw new IllegalArgumentException(exStr);
        }
        this.directoryPath = directoryPath;
        this.queue = queue;
    }

    @Override
    /*
    тут в качестве возвращаемого значения испльзуется класс Void! Это говорит о том, что не надо ждать
    возвращаемых результатов
     */
    public Void call() throws InterruptedException {
        searchFiles(directoryPath);
        queue.put(STOP_WORK);
        return null;
    }

    private void searchFiles(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                searchFiles(file);
            } else {
                queue.put(file);
            }
        }
    }
}
