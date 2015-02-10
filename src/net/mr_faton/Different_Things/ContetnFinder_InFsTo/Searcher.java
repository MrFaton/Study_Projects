package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by root on 09.02.2015.
 */
public class Searcher {
    public static final StringBuilder STOP = new StringBuilder("STOP");
    public static void main(String[] args) {
        BlockingQueue<StringBuilder> queue = new ArrayBlockingQueue<>(10);
        TreeSet<Page> content = new TreeSet<>();
        new PageSearcher(queue, "http://fs.to/video/films/", 2).parsePages();
        new PageHandler(queue, content).handlePages();
    }
}
