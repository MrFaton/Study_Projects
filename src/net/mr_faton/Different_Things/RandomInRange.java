package net.mr_faton.Different_Things;

/**
 * Created by root on 02.11.2014.
 */
public class RandomInRange {
    public static void main(String[] args) {
        int min = 5;
        int max = 10;
        for (int i = 0; i < 10; i++) {
            int rnd = min + (int) (Math.random() * ((max - min) + 1));
            System.out.println("Случайное чисто в диапазоне от " + min + " до " + max + " = " + rnd);
        }
    }
}
