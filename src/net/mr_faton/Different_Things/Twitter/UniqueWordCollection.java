package net.mr_faton.Different_Things.Twitter;

import java.io.*;
import java.util.*;

/**
 * Created by Mr_Faton on 23.06.2015.
 */
public class UniqueWordCollection {
    private static final File FILE_SER = new File("D:\\Twitter\\UniqueWordCollection.ser");
    private static final File FILE_TWEET = new File("D:\\Twitter\\Все твиты.txt");
    private final Set<String> STORAGE;

    public UniqueWordCollection() {
        STORAGE = loadStorage();
    }

    public Set<String> getUniqueWordCollection() {
        return STORAGE;
    }

    private final Set<String> loadStorage() {
        if (FILE_SER.exists()) {
            try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(FILE_SER))) {
                Set<String> set = (TreeSet<String>) objectIn.readObject();
                return set;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Set<String> uniqueWords = new TreeSet<>();
        try {
            Scanner scanner = new Scanner(FILE_TWEET);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineTokens = line.split(" ");
                for (String token : lineTokens) {
                    if (token.contains("@")) {
                        continue;
                    }
                    String cleanToken = token.replaceAll("[^а-яА-Яa-zA-z]", "");
                    if (cleanToken.length() > 0) {
                        uniqueWords.add(cleanToken);
                    }
                }
            }
            saveCollection(uniqueWords);
            return uniqueWords;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final void saveCollection(Set<String> set) {
        System.out.println("saving");
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(FILE_SER))) {
            objectOut.writeObject(set);
            objectOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Test {
    public static void main(String[] args) {
        UniqueWordCollection uniqueWordCollection = new UniqueWordCollection();
        Set<String> uniqueWords = uniqueWordCollection.getUniqueWordCollection();
        System.out.println("containce абулия = " + uniqueWords.contains("абулия"));
        System.out.println(uniqueWords.size());
    }
}