package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

import java.io.*;
import java.net.URL;
import java.util.concurrent.BlockingQueue;

/**
 * Created by root on 09.02.2015.
 */
public class PageSearcher {
    private BlockingQueue<StringBuilder> queue;
    private final String site;
    private final int pages;
    private final String additionalPart = "?page=";
    private int counter = 0;

    public PageSearcher(BlockingQueue<StringBuilder> queue, String site, int pages) {
        this.queue = queue;
        this.site = site;
        this.pages = pages;
    }

    public void parsePages() {
        String url = site + additionalPart + counter;
        if (counter == 0) {
            url = site;
        }
        StringBuilder page = new StringBuilder();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"))) {
            int ch;
            while ((ch = in.read()) != -1) {
                page.append((char) ch);
            }
            queue.put(page);
        }catch (IOException | InterruptedException ex) {
            System.err.println("Произошла ошибка при чтении из ЮРЛ или при добавлении страницы в очередь");
            ex.printStackTrace();
        }
        counter++;
        if (counter < pages) parsePages();

        try {
            queue.put(Searcher.STOP);
        } catch (InterruptedException e) {
            System.err.println("Произошла ошибка при добавлении страницы в очередь");
            e.printStackTrace();
        }
    }
}
