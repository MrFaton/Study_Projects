package net.Horstmann_Example_T2.Chapter1;

import java.io.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.util.Scanner;

/**
 * Created by Mr_Faton on 06.02.2015.
 */
public class App04_ZipInputOutput {
    public static void main(String[] args) {
        //Обычные файлы на компе, из которых будем читать данные
        String fileIn1 = "D:\\Java\\Study_Projects\\src\\net\\Horstmann_Example_T2\\Chapter1\\Files\\fileIn1.txt";
        String fileIn2 = "D:\\Java\\Study_Projects\\src\\net\\Horstmann_Example_T2\\Chapter1\\Files\\fileIn2.txt";
        String fileIn3 = "D:\\Java\\Study_Projects\\src\\net\\Horstmann_Example_T2\\Chapter1\\Files\\fileIn3.txt";
        //чужой архив, созданный кем-то другим, из которого будеи читать данные
        String zipArchive = "D:\\Java\\Study_Projects\\src\\net\\Horstmann_Example_T2\\Chapter1\\Files\\zipArchive.zip";
        //архив, который создаём мы и куда будем сохранять данные
        String zipArchiveMadeByJava = "D:\\Java\\Study_Projects\\src\\net\\Horstmann_Example_T2\\Chapter1\\Files\\zipArchiveMadeByJava.zip";
        //файл, в который сохраним данные, извлечённые из чужого архива
        String fileOut = "D:\\Java\\Study_Projects\\src\\net\\Horstmann_Example_T2\\Chapter1\\Files\\fileOut.txt";
        //имена файлов, которые будут сохранены внутри нашего зип архива
        String zipFile1 = "zipFile1.txt";
        String zipFile2 = "zipFile2.txt";

        /*
        пробуем сделать следующее:
        1) создаём архив zipArchiveMadeByJava.zip
        2) читаме информацию из 2-х файлов fileIn1 и fileIn2 и записываем её в 1 файл под именем  zipFile1 в архив
        3) читам информацию из 1-ного файла fileIn3 и записываем её в 1 файл под именем zipFile2 в архив
         */
        try {
            //создаём поток вывода в зип файл
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipArchiveMadeByJava));
            //создаём 3 сканера для чтения данных из наших трёх файлов, которые хотим сохранить в зим архиве
            Scanner in1 = new Scanner(new FileInputStream(fileIn1), "cp1251");
            Scanner in2 = new Scanner(new FileInputStream(fileIn2), "cp1251");
            Scanner in3 = new Scanner(new FileInputStream(fileIn3), "cp1251");
            //создаём 2 файла, которые будут находиться в нашем конечном архиве
            ZipEntry entryFile1 = new ZipEntry(zipFile1);
            ZipEntry entryFile2 = new ZipEntry(zipFile2);
            //создём первый тестовый файл (который будт выводиться в архив), его имя будет zipFile1.txt
            zout.putNextEntry(entryFile1);
            while (in1.hasNext()) {
                //читаем данные из первого файла, преобразовываем в байтовый массив и записываем в первый текстовый файл внутри архива
                zout.write(in1.nextLine().getBytes());
            }
            while (in2.hasNext()) {
                //читаем данный из второго файла, преобразовываем в байтовый массив и запысываем опять же в первый текстовый файл внутри архива
                zout.write(in2.nextLine().getBytes());
            }
            //сбрасываем в файл все буфера потока
            zout.flush();
            //закрываем первый текстовый файл внутри нашего архива
            zout.closeEntry();
            ////создём второй тестовый файл (который будт выводиться в архив), его имя будет zipFile2.txt
            zout.putNextEntry(entryFile2);
            while (in3.hasNext()) {
                zout.write(in3.nextLine().getBytes());
            }
            zout.flush();
            //закрыли второй файл (zipFile2.txt)
            zout.closeEntry();
            //закрыли поток вывода
            zout.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
            return;
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл");
            return;
        }


        //пробуем читать данные из чужого зип архива
        try {
            //создаём поток ввода из зип архива
            ZipInputStream zin = new ZipInputStream(new FileInputStream(zipArchive));
            //конструируем сущьность (файл), который может быть в зим архиве
            ZipEntry entry;
            //создаём поток вывода в файл
            PrintWriter out = new PrintWriter(fileOut);
            //делаем цикл по принципу: пока в архиве есть файлы
            while ((entry = zin.getNextEntry()) != null) {
                //создайм поток ввода из файла из зип архива
                Scanner in = new Scanner(zin, "cp1251");
                //проверяем, содержиться ли в конкретном файле из архива ещё строки
                while (in.hasNextLine()) {
                    String str = in.nextLine();
                    //отправляем строку в поток вывода
                    out.println(str);
                }
                //закрываем текущий файл в архиве
                zin.closeEntry();
            }
            //сбрасываем буффера потока вывода в файл
            out.flush();
            //закрываем поток ввода из зип архива
            zin.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
            return;
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл");
            return;
        }
    }
}
