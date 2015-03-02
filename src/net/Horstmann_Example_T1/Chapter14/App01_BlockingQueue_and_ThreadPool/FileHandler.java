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
    //блокирующая очередь, в которой лежиат пути к файлам
    private BlockingQueue<File> queue;
    //ключевое слово для поиска
    private final String keyWord;
    //пулл потоков, куда мы будем ложить задачу поиска ключевого слова в файле
    private final ExecutorService threadPool;
    //считчик максимального колличества потоков, зафиксированного в пуле
    private int maxCountOfThreads = 0;

    public FileHandler(String keyWord, BlockingQueue<File> queue, final ExecutorService threadPool) {
        //проверяем содержит ли keyWord хоть какое-то значение
        if (keyWord.length() == 0 | keyWord == null) {
            String exStr = "Неверное ключевое слово: " + keyWord;
            throw new IllegalArgumentException(exStr);
        }
        this.keyWord = keyWord;
        this.queue = queue;
        this.threadPool = threadPool;
    }

    //тело нашего потока-обработчика файлов
    public void run() {
        while (true) {
            //в этой переменной содержится пусть к обрабатываемому файлу
            File currentFile;
            try {
                //берём путь к файлу из очереди
                currentFile = queue.take();
            } catch (InterruptedException e) {
                break;
            }
            //если файл НЕ равен файлу остановки, обрабатываем текущий файл, иначе прекращаем цикл обработки
            if (currentFile != FileSearcher.STOP_WORK) {
                //создаём новый поток обработчика Worker и бросаем его в пулл потоков на выполнение
                threadPool.submit(new Worker(currentFile));
                //посчитываем максимальное число потоков в пуле
                maxCountOfThreads = Math.max(((ThreadPoolExecutor) threadPool).getPoolSize(), maxCountOfThreads);
            } else {
                try {
                    //если файл равен файлу остановке, ложим его обратно в очередь и останавливаемся
                    queue.put(currentFile);
                } catch (InterruptedException e) {
                    break;
                }
                //выключаем пулл потоков!!!
                threadPool.shutdown();
                System.out.println("Максимально колличество потоков во время работы: " + maxCountOfThreads);
                break;
            }
        }
    }

    /*
    Класс, имплементящий интерфайс Runnable. В его методе run хранится задача (логика) обработки файла из очереди.
    Экземпляр этого класса передаётся пулу потоков для реализации. Пул потоков мог принять наследника Callable
     */
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
//Класс, который берёт из очереди файл и ощет в нём ключевое слово. Организован он с помощью имплементации Runnable