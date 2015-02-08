package net.Horstmann_Example_T2.Chapter1.App07_FileAttributes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * Created by root on 08.02.2015.
 */
public class Attributes_Test {
    public static void main(String[] args) {
        Path path = Paths.get("src\\net\\Horstmann_Example_T2\\Chapter1\\App07_FileAttributes\\Test.txt");
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Время создания: " + attributes.creationTime());
            System.out.println("Вермя последнего доступа: " + attributes.lastAccessTime());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
