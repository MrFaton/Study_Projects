package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Faton on 09.02.2015.
 */
public class PageHandler {
    private StringBuilder page;
    private BlockingQueue<StringBuilder> queue;
    private List<Content> contentList;
    private String regExp = "(.*title-full\">)(\\s*+)(.*?)\\s+<|(.*vote-positive\">)([0-9]*?)<|(.*vote-negative\">)([0-9]*?)<";
    private String name = "";
    private int positiveVotes = 0;
    private int negativeVotes = 0;
    private int count = 1;

    public PageHandler(BlockingQueue<StringBuilder> queue, List<Content> contentList) {
        this.queue = queue;
        this.contentList = contentList;
    }

    public void handlePages() {
        try {
            page = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (page != Searcher.STOP) {
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(page);
            while (matcher.find()) {
                if (matcher.group(3) != null) {
                    name = matcher.group(3);
                }
                if (matcher.group(5) != null) {
                    positiveVotes = Integer.parseInt(matcher.group(5));
                }
                if (matcher.group(7) != null) {
                    negativeVotes = Integer.parseInt(matcher.group(7));
                    if (positiveVotes >= Searcher.VOTE_BARRIER) {
                        contentList.add(new Content(name, positiveVotes, negativeVotes));
                    }
                }
            }
            System.out.println("Total pages: " + Searcher.NUM_OF_PAGES + " processing page #" + count++);
            handlePages();
        } else {
            try {
                queue.put(page);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}