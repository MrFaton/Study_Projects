package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 09.02.2015.
 */
public class PageHandler {
    private BlockingQueue<StringBuilder> queue;
    private final String regExp = "(.*title-full\">)(.*?)</span>(.*vote-positive\\\">)(.*?)</span>(.*vote-negative\\\">)(.*?)</span>";
    private TreeSet<Page> content;
    private Pattern pattern;
    private Matcher matcher;

    public PageHandler(BlockingQueue<StringBuilder> queue, TreeSet<Page> content) {
        this.queue = queue;
        this.content = content;
    }

    public void handlePages() {
        try {
            StringBuilder page = queue.take();
            if (page == Searcher.STOP) {
                queue.put(page);
                return;
            }
            pattern = Pattern.compile(regExp);
            matcher = pattern.matcher(page);

            while (matcher.find()) {
                System.out.println(matcher.group(2));
                System.out.println(matcher.group(4));
                System.out.println(matcher.group(6));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
