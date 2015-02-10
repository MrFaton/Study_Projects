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
    public static int VOTE_BARRIER = 2500;
    public static int NUM_OF_PAGES = 80;
    public static String url = "";
    public static final StringBuilder STOP = new StringBuilder("STOP");

    public static void main(String[] args) {
        System.out.println("Enter URL (like http://fs.to/video/films/):");
        Scanner input = new Scanner(System.in);
        url = input.nextLine();
        System.out.println("Enter vote barrier (like 2500):");
        VOTE_BARRIER = Integer.parseInt(input.nextLine());
        System.out.println("Enter num of process pages (like 80):");
        NUM_OF_PAGES = Integer.parseInt(input.nextLine());

        System.out.println("Program is working...");
        long workTime = System.currentTimeMillis();
        final BlockingQueue<StringBuilder> queue = new ArrayBlockingQueue<>(10);
        final List<Content> content = new ArrayList<>();
        Thread searcher = new Thread(new Runnable() {
            @Override
            public void run() {
                new PageSearcher(queue).parsePages("http://fs.to/video/films/");
//                new PageSearcher(queue).parsePages("http://fs.to/audio/collections/");
//                new PageSearcher(queue).parsePages("http://fs.to/video/films/?sort=new");
            }
        });
        Thread handler = new Thread(new Runnable() {
            @Override
            public void run() {
                new PageHandler(queue, content).handlePages();
            }
        });
        searcher.start();
        handler.start();
        try {
            handler.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        saveListToFile(content);
        workTime = System.currentTimeMillis() - workTime;
        System.out.println("Work done in " + workTime / 1000 / 60 + " minutes and " + workTime / 1000 + " seconds");
    }

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

        }
    }
}
