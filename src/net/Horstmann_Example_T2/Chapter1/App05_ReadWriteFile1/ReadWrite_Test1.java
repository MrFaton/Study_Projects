package net.Horstmann_Example_T2.Chapter1.App05_ReadWriteFile1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by root on 08.02.2015.
 */
public class ReadWrite_Test1 {
    public static void main(String[] args) {
        //отображает рабочую папку в данный момент
        System.out.println("Моя рабочая папка: " + System.getProperty("user.dir") + "\n");
        /*
        устанавливает абсолютный (полный, от начала до имени файла) путь. Путь можно вводить отдельными строками:
        например "Study_Projects". Если ввести таким образом путь, то в зависимости от операционки JVM сама
        сформирует правильный путь (для Винды: С:\, для ЮНИКС /хоме)
         */
        Path absolute = Paths.get("X:\\", "Faton", "Java", "Study_Projects", "src", "net", "Horstmann_Example_T2\\Chapter1\\App05_ReadWriteFile1", "Test.txt");
        printWay1("Файл с абсолютным путём", absolute);
        printWay2("абсолютным", absolute);

        Path relative = Paths.get("src\\net\\Horstmann_Example_T2\\Chapter1\\App05_ReadWriteFile1\\Test.txt");
        printWay1("Файл с относительным путём", relative);
        printWay2("относительным", relative);

    }

    //метод извлекает все байты из файла и помещает их в байтовый массив. Далее из него формируется строка с указанием кодировки
    public static void printWay1(String str, Path path) {
        System.out.println("***Печать файла через байтовый массив***\n" + "+++" + str + "+++");
        try {
            byte[] buf = Files.readAllBytes(path);
            String text = new String(buf, "UTF-8");
            System.out.println(text);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла в методе printWay1");
            e.printStackTrace();
            return;
        }
        System.out.println("*****\n");
    }

    //данный метод читает из файл построчно данные и сохраняет каждую строку в список строк
    public static void printWay2(String str, Path path) {
        System.out.println("----Печать первой стоки файла с " + str + " путём при помощи List: ");
        try {
            List<String> list = Files.readAllLines(path, Charset.forName("UTF-8"));
            System.out.println(list.get(0));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла в методе printWay2");
            e.printStackTrace();
            return;
        }
        System.out.println("----\n");
    }

}