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
    //очередь из которой берём страницу
    private BlockingQueue<StringBuilder> queue;
    //коллекция, в которую ложим обработанный результат
    private List<Content> contentList;
    //регулярное выражение, при помощи которого осуществляется поиск имени, позитивных и негативных голосов
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
        //берём страницу из очереди
        try {
            page = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        выполняем проверку, равна ли страница, странице, которая сигнализирует об остановке процесса, если да, то
        прерываем работы, если нет, продолжаем обработку сраницы и рекурсивно вызываем сами себя, чтобы получить и
        обработать новую страницу
         */
        if (page != Searcher.STOP) {
            //формируем шаблон, по которому будем искать необходимые нам данные (имя и голоса)
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(page);
            //запускаем поиск по шаблону. Если поиск что-то нашёл, пытаемся обработать результат
            while (matcher.find()) {
                //пытаемся получить имя
                if (matcher.group(3) != null) {
                    name = matcher.group(3);
                }
                //пытаемся получить позитивное количество голосов
                if (matcher.group(5) != null) {
                    positiveVotes = Integer.parseInt(matcher.group(5));
                }
                //пытаемся получить негативное количество голосов
                if (matcher.group(7) != null) {
                    negativeVotes = Integer.parseInt(matcher.group(7));
                    /*
                    если позитивное кол-во голосов больше заданного барьера, формиреум объект класса Content и
                     добавляем его в коллекцию
                     */
                    if (positiveVotes >= Searcher.VOTE_BARRIER) {
                        contentList.add(new Content(name, positiveVotes, negativeVotes));
                    }
                }
            }
            System.out.println("Total pages: " + Searcher.NUM_OF_PAGES + " processing page #" + count++);
            //рекурсивно запускаем процесс обработки страницы
            handlePages();
        } else {
            //Если страница = странице, сигнализирующей об остановке процесса
            try {
                queue.put(page);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
Класс-обработчик страниц с содержимым. Одна страница с содержимым содержит в себе 18 единиц контента (фильмы, музыка).
Этот класс берёт одну страницу из блокирующей очереди и обрабатывает её, а именно, находит название содержимого, а так же
количество позитивных и негативных голосов, далее формируе объект класса Content, сохраняя в него полученные значения и
и отпраляет этот объект в переданную коллекцию
 */