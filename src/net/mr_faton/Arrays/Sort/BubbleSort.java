package net.mr_faton.Arrays.Sort;

import java.util.Arrays;

/**
 * Created by Mr_Faton on 13.01.2015.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = (int) (Math.random() * 10);
        }
        System.out.println("Наш массив:\n" + Arrays.toString(data));
        bubbleSortIter(data);
    }

    public static void bubbleSortIter(int[] data) {
        for (int x = data.length - 1; x >= 0; x--) {
            for (int i = 0; i < x; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив итерационным ПУЗЫРЬКОМ:\n" + Arrays.toString(data));
    }
}
