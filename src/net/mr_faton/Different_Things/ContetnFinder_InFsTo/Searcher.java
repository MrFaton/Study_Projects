package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by root on 09.02.2015.
 */
public class Searcher {
    //барьер положительных голосов, ниже которого остальной контент игнорируется
    public static int VOTE_BARRIER;
    //количество страниц, которых необходимо обработать
    public static int NUM_OF_PAGES;
    //ссылка на первую страницу с данными
    public static String url = "";
    //страница, которая сигнализирует обработчику, что это последняя обрабатываемая страница
    public static final StringBuilder STOP = new StringBuilder("STOP");

    public static void main(String[] args) {
        //просим ввести ссылку на первую страницу, мин кол-во позитивных голосов и кол-во обрабатываемых страниц
        System.out.println("Enter URL or any button for default (http://fs.to/video/films/):");
        Scanner input = new Scanner(System.in);
        url = input.nextLine();
        if (url.length() < 7) {
            url = "http://fs.to/video/films/";
            System.out.println("accepting default URL: http://fs.to/video/films/");
        }
        System.out.println("Enter vote barrier (like 2500):");
        VOTE_BARRIER = Integer.parseInt(input.nextLine());
        System.out.println("Enter num of process pages (like 80):");
        NUM_OF_PAGES = Integer.parseInt(input.nextLine());

        System.out.println("Program is working...");
        long workTime = System.currentTimeMillis();
        //создаём блокирующую очердь
        final BlockingQueue<StringBuilder> queue = new ArrayBlockingQueue<>(10);
        //создаём коллекцию для хранения контента
        final List<Content> content = new ArrayList<>();
        //создаём поток для поисковика
        Thread searcher = new Thread(new Runnable() {
            @Override
            public void run() {
                new PageSearcher(queue).parsePages(url);
//                new PageSearcher(queue).parsePages("http://fs.to/audio/collections/");
//                new PageSearcher(queue).parsePages("http://fs.to/video/films/?sort=new");
            }
        });
        //создаём поток для обработчика
        Thread handler = new Thread(new Runnable() {
            @Override
            public void run() {
                new PageHandler(queue, content).handlePages();
            }
        });
        //запускаем поисковик
        searcher.start();
        //запускаем обработчик
        handler.start();
        //дожидаемя завершения работы обработчика
        try {
            handler.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //сохраняем коллекцию с контентом в файл
        saveListToFile(content);
        workTime = System.currentTimeMillis() - workTime;
        long min = workTime / 1000 / 60;
        long sec = (workTime / 1000) - (min * 60);
        System.out.println("Work done in " + min + " minutes and " + sec + " seconds");
    }

    //метод сохраняет контент в файл
    public static void saveListToFile(List<Content> contents) {
        Collections.sort(contents);
        String count = "В списке: " + contents.size() + " элемента(ов)";
        try (BufferedWriter out = new BufferedWriter(new PrintWriter("D:\\Лучшие фильмы.txt"))) {
            out.write(count);
            out.newLine();
            for (Content item : contents) {
                out.write(item.toString());
                out.newLine();
                out.newLine();
            }
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
/*
Основной каласс. Запускает в одом потоке класс-поисковик, а в другом потоке класс-обработчик и связываем их через
одну блокирующую очередь
 */