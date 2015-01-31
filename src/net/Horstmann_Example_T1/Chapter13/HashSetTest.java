package net.Horstmann_Example_T1.Chapter13;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by root on 31.01.2015.
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Scanner in = null;

        long totalTime = 0;
        try {
            in = new Scanner(new BufferedReader(new FileReader("X:\\Faton\\Java\\Этюд в багровых тонах.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("НЕ удалось найти файл...");
            System.exit(0);
        }

        int allWords = 0;
        while (in.hasNext()) {
            long startTime = System.currentTimeMillis();
            String word = (in.next()).replaceAll("[^а-яА-Я]", "");
            if (word.length() > 0) {
                hashSet.add(word);
            }
            startTime = System.currentTimeMillis() - startTime;
            totalTime += startTime;
            allWords++;
        }

        System.out.println("Работа завершена за: " + totalTime + " миллисекунд");
        System.out.println("Всего слов в файле: " + allWords + ", из них уникальных: " + hashSet.size());

        System.out.println("вывести из них первые 20 шт:");
        Iterator<String> iter = hashSet.iterator();
        int i = 0;
        while (iter.hasNext() && i < 20) {
            System.out.println(iter.next());
            i++;
        }
    }
}
