package net.mr_faton.Different_Things.FilmFinder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by root on 09.02.2015.
 */
public class FilmSearcher {
    public static final StringBuilder STOP = new StringBuilder("STOP");
    public static void main(String[] args) {
        BlockingQueue<StringBuilder> queue = new ArrayBlockingQueue<>(10);
        new PageSearcher(queue, "http://fs.to/video/films/", 2).parsePages();

    }
}
