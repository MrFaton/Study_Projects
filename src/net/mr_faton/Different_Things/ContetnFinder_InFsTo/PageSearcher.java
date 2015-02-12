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
    //блокирующая очередь, в которую ложим найденную страницу
    private BlockingQueue<StringBuilder> queue;
    //шалон, по которому ищем ссылку для перехода на следующую страницу
    private final String regExp = "(.*next-link\"href=\")(.*?)\"";
    private Pattern pattern;
    private Matcher matcher;
    //счётчик найденных страниц
    private int counter = 0;

    public PageSearcher(BlockingQueue<StringBuilder> queue) {
        this.queue = queue;
    }

    public void parsePages(String url) {
        StringBuilder page = new StringBuilder();
        //скачиваем страницу и ложим её в переменную page
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"))) {
            int ch;
            while ((ch = in.read()) != -1) {
                page.append((char) ch);
            }
            //ложим страницу
            queue.put(page);

        } catch (IOException | InterruptedException ex) {
            System.err.println("Произошла ошибка при чтении из ЮРЛ или при добавлении страницы в очередь");
            ex.printStackTrace();
        }
        //формируем шаблон, который находит ссылку на следующую страницу, которую необходимо загрузить
        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(page);
        if (matcher.find()) {
            url = "http://fs.to" + matcher.group(2);
        } else {
            System.err.println("Не удалось получить ссылку на следующую страницу...");
            return;
        }
        /*
        добавляем к счётчику обработанных страниц 1 и сравниваем его с требуемым результатом. Например если необходимо
        скачать 50 страниц, то мы смотрим сколько мы скачали и сравниваем с тем, сколько необходимо.
         */
        counter++;
        if (counter < Searcher.NUM_OF_PAGES) {
            parsePages(url);

        } else {
            try {
                queue.put(Searcher.STOP);
            } catch (InterruptedException e) {
                System.err.println("Произошла ошибка при добавлении страницы в очередь");
                e.printStackTrace();
            }
        }
    }
}
//Класс-поисковик. Занимается тем, что ложин найденные страницы в блокирующию очередь для обработки