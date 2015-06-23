package net.mr_faton.Test;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Mr_Faton on 23.06.2015.
 */
public class Test2 {
    private static final File FILE_SER = new File("D:\\Twitter\\UniqueWordCollection.ser");

    public static void main(String[] args) {
        String str = "просто,as";
        String cleanToken = str.replaceAll("[^а-яА-Яa-zA-Z]", "");
        System.out.println(cleanToken);

        Set<String> set = new TreeSet<>();
        set.add("привет");
        set.add("азбука");
        set.add("якорь");
        set.add("итер");
        set.add("с");
        set.add("aspect");
        set.add("итер");
        set.add("с");
        System.out.println(set);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_SER))) {
            objectOutputStream.writeObject(set);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
