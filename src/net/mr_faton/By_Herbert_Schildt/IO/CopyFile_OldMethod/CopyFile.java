package net.mr_faton.By_Herbert_Schildt.IO.CopyFile_OldMethod;

import java.io.*;

/**
 * Created by root on 14.12.2014.
 */

class StartCopyFile {
    public static void main(String[] args) {
        System.out.println("Начало работы программы\n");
        new CopyFile().run();
        System.out.println("\nПрограмма завершена");
    }
}


public class CopyFile {
    private String inFile;
    private String outFile;
    private FileInputStream fin = null;
    private FileOutputStream fout = null;

    public CopyFile() {
        try {
            System.out.println("Имя файла, который нужно скопировать:");
            do {
                inFile = new BufferedReader(new InputStreamReader(System.in)).readLine();//всё это вернёт нам прочитанную строку из консоли
                if (inFile.length() < 3) System.out.println("Введено неверное имя файла ввода. Попробуй ещё раз...");
            } while (inFile.length() < 3);

            System.out.println("Имя файла, куда сохранить копию:");
            do {
                outFile = new BufferedReader(new InputStreamReader(System.in)).readLine();//тут можно не использовать конструкцию this.outFile, потому что outFile у нас один
                if (outFile.length() < 3) System.out.println("Введено неверное имя файла вывода. Попробуй ещё раз...");
            } while (outFile.length() < 3);

        } catch (IOException e) {
            System.out.println("Ошибка чтения из командной строки " + e);
            e.printStackTrace();
            return;
        }
    }

    public void run() {
        try {
            fin = new FileInputStream(inFile);
        } catch (FileNotFoundException ex) {
            System.out.println("Исходный файл не найден... " + ex);
            return;
        }

        try {
            fout = new FileOutputStream(outFile);
        } catch (FileNotFoundException ex) {
            System.out.println("Проблема открытия для записи конечного файла... " + ex);
            return;
        }

        try {
            int i;
            do {
                i = fin.read();//побайтовое чтение
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException ex) {
            System.out.println("Ошибка чтения/записи файла " + ex);
            return;
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
                System.out.println("Невозможно закрыть входящий файл  " + ex);
                return;
            }

            try {
                fout.close();
            } catch (IOException ex) {
                System.out.println("Невозможно закрыть конечный файл  " + ex);
                return;
            }
        }
    }
}
