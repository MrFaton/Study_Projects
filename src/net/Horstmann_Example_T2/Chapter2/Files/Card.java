package net.Horstmann_Example_T2.Chapter2.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 16.02.2015.
 */
public class Card implements Serializable {
    private String engWord;
    private int numOfGuess;
    private String[] translate;
    private String[] example;
    private String sound;

    public Card(String engWord, int numOfGuess, String[] translate, String[] example, String sound) {
        this.engWord = engWord;
        this.numOfGuess = numOfGuess;
        this.translate = translate;
        this.example = example;
        this.sound = sound;
    }

    public String getEngWord() {
        return engWord;
    }

    public int getNumOfGuess() {
        return numOfGuess;
    }

    public String[] getTranslate() {
        return translate;
    }

    public String[] getExample() {
        return example;
    }

    public String getSound() {
        return sound;
    }

    public String toString() {
        return "Английское слово: " + engWord +
                "\nугадано: " + numOfGuess +
                "\nперевод: " + Arrays.toString(translate) +
                "\nпримеры: " + Arrays.toString(example) +
                "\nзвук: " + sound;
    }
}
/*
Экземпляр этого класса отображает карточку английского слова
 */


class TestCard {
    public static File file = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\CardList.ser");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        List<Card> list = new ArrayList<>(5);
//        list.add(new Card("Tuesday", 2, new String[]{"вторник"}, new String[]{"I like Tuesday"}, ""));
//        list.add(new Card("Wednesday", 5, new String[]{"среда", "средоо"}, new String[]{"nice wednesday", "N & W"}, "wednesday.wav"));
//        list.add(new Card("Thursday", 8, new String[]{"четверг", "чт", "четвергоо"}, new String[]{"pure thursday", "in Thursday"}, ""));
//
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//        out.writeObject(list);
//        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        ArrayList<Card> restoredList = (ArrayList) in.readObject();
        System.out.println(restoredList);
    }
}
/*
Создаём три карточки и сериализуем наш список этих карточек
 */
