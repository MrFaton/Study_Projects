package net.Horstmann_Example_T1.Chapter14.App01_BlockingQueue_and_ThreadPool;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by root on 04.02.2015.
 */
public class FileSearcher implements Runnable {
    //блокирующая очередь
    private BlockingQueue<File> queue;
    //пусть к корнеовой папке
    private File directoryPath;
    //файл, символизирующий остановку процесса обработики файлов (поиска ключевого слова)
    public static final File STOP_WORK = new File("STOP");

    public FileSearcher(File directoryPath, BlockingQueue<File> queue) {
        if (directoryPath == null) {
            String exStr = "Передан пустой аргумент... Путь к файлу: " + directoryPath;
            throw new IllegalArgumentException(exStr);
        }
        this.directoryPath = directoryPath;
        this.queue = queue;
    }

    public void run() {
        try {
            searchFiles(directoryPath);
            queue.put(STOP_WORK);
        } catch (InterruptedException ex) {
            System.out.println("Поток прерван по требованию");
            return;
        }
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
/*
класс, который занимается поиском всех файлов в указаном каталоке, находит файлы также во всех подкаталогах и ложит в
очередь
 */