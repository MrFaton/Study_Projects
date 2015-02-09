package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 09.02.2015.
 */
public class PageHandler {
    private BlockingQueue<StringBuilder> queue;
    private final String regExpName = "";
    private final String regExpPositiveVotes = "";
    private TreeMap<String, Integer> content;
    private Pattern patternVote;
    private Pattern patternName;
    private Matcher matcherVote;
    private Matcher matcherName;

    public PageHandler(BlockingQueue<StringBuilder> queue, TreeMap<String, Integer> content) {
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

            patternVote = Pattern.compile(regExpPositiveVotes);
            matcherVote = patternVote.matcher(page);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
