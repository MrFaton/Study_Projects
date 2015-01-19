package net.mr_faton.Different_Things;

/**
 * Created by Mr_Faton on 14.01.2015.
 */
public class Fibanachi {
    public static void main(String[] args) {
        int arg = 5;
        System.out.println("Фибаначи от " + arg + " = " + calculateFibanachi(arg));
    }

    public static int calculateFibanachi(int arg) {
        if (arg == 0 || arg == 1) {
            return 1;
        } else {
            return calculateFibanachi(arg - 2) + calculateFibanachi(arg - 1);
        }
    }
}
