package net.mr_faton.Different_Things;

import java.io.IOException;

/**
 * Created by Faton on 07.12.2014.
 */
public class ReadFromConsol {
    public static void main(String[] args) throws IOException {
        char input;
        do {
            System.out.println("Сдлелай выбор");
            System.out.println("1 - сложение чисел");
            System.out.println("2 - вычитание чисел");
            System.out.println("3 - умножение чисел");
            System.out.println("4 - разность чисел");
            input = (char) System.in.read();
        } while (input < '0' || input > '5');

        switch (input) {
            case '1':
                System.out.println("будем скалывать");
                break;
            case '2':
                System.out.println("будем вычитать");
                break;
            case '3':
                System.out.println("будем уможать");
                break;
            case '4':
                System.out.println("будем делить");
                break;
            default:
                System.out.println("");
        }
    }
}
