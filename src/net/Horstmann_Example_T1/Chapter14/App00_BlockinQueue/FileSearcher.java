package net.Horstmann_Example_T1.Chapter14.App00_BlockinQueue;

import java.util.concurrent.BlockingQueue;
import java.io.File;

/**
 * Created by root on 04.02.2015.
 */
public class FileSearcher implements Runnable {
    private BlockingQueue<File> queue;
    private File directoryPath;
    //передаёт в очередь этот файл, сигнализируя потокам-обработчикам о том, что файлов к добавлению в очередь уже нет
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
            //поисковик и забиватель файлов в очередь
            searchFiles(directoryPath);
            //когда файлы в каталоге закончились, добавляет этот файл, сигнализируя об окончании работы
            queue.put(STOP_WORK);
        } catch (InterruptedException ex) {
            System.out.println("Поток прерван по требованию");
            return;
        }
    }

    //ищет и добавляет файлы в очередь
    private void searchFiles(File directory) throws InterruptedException {
        //получем список файлов в каталоге
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                //если это папка, то заходим в неё рекурсивно и перебираем там все файлы
                searchFiles(file);
            } else {
                //если не папка, то добавляем файл в очередь
                queue.put(file);
            }
        }
    }
}
//класс, который занимается поиском всех файлов в указаном каталоке, находит файлы также во всех подкаталогах