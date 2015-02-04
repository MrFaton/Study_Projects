package net.Horstmann_Example_T1.Chapter14.App00_BlockinQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Created by root on 04.02.2015.
 */
public class FileHandler implements Runnable {
    private BlockingQueue<File> queue;
    private final String keyWord;

    public FileHandler(String keyWord, BlockingQueue<File> queue) {
        if (keyWord.length() == 0 | keyWord == null) {
            String exStr = "Какое-то из значений является пустым: ключевое слово: " + keyWord;
            throw new IllegalArgumentException(exStr);
        }
        this.keyWord = keyWord;
        this.queue = queue;
    }

    public void run() {
        try {
            boolean done = false;

            //работаем, пока не наткнёмся на особый файл из класса FileSearcher под назаванием File STOP_WORK = new File("STOP");
            while (!done) {
                File file = queue.take();
                if (file == FileSearcher.STOP_WORK) {
                    queue.put(file);
                    done = true;
                } else {
                    processFile(file);
                }
            }
        } catch (InterruptedException | FileNotFoundException ex) {
            System.out.println("Ошибка при работе с очередью или файл не найден...");
            return;
        }
    }

    //обрабатывает файл, а именно ищет в нём заданое слово
    private void processFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        int lineNumber = 0;
        while (in.hasNext()) {
            lineNumber++;
            String line = in.nextLine();
            if (line.contains(keyWord)) {
                System.out.println("Искомое слово найдено в файле: " + file.getPath() + ", в строке: " + lineNumber + ", строка: " + line);
            }
        }
    }
}
//Класс, который берёт из очереди файл и ощет в нём ключевое слово