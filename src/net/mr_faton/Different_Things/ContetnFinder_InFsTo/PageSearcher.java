package net.mr_faton.Different_Things.ContetnFinder_InFsTo;

import java.io.*;
import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 09.02.2015.
 */
public class PageSearcher {
    private BlockingQueue<StringBuilder> queue;
    private final String regExp = "(.*next-link\"href=\")(.*?)\"";
    private Pattern pattern;
    private Matcher matcher;

    private int counter = 0;

    public PageSearcher(BlockingQueue<StringBuilder> queue) {
        this.queue = queue;
    }

    public void parsePages(String url) {

        StringBuilder page = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"))) {
            int ch;
            while ((ch = in.read()) != -1) {
                page.append((char) ch);
            }
            queue.put(page);
        } catch (IOException | InterruptedException ex) {
            System.err.println("Произошла ошибка при чтении из ЮРЛ или при добавлении страницы в очередь");
            ex.printStackTrace();
        }
        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(page);
        if (matcher.find()) {
            url = "http://fs.to" + matcher.group(2);
        } else {
            System.err.println("Не удалось получить ссылку на следующую страницу...");
            return;
        }

        counter++;
        if (counter < Searcher.NUM_OF_PAGES) {
            parsePages(url);
        }

        try {
            queue.put(Searcher.STOP);
        } catch (InterruptedException e) {
            System.err.println("Произошла ошибка при добавлении страницы в очередь");
            e.printStackTrace();
        }
    }
}
