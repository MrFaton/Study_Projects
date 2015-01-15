package net.mr_faton.Arrays.Sort;

import java.util.Arrays;

/**
 * Created by Mr_Faton on 13.01.2015.
 */
public class PastSort {
    public static void main(String[] args) {
        int[] data = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = (int) (Math.random() * 10);
        }
        System.out.println("Наш массив:\n" + Arrays.toString(data));
        pastSortIter(data);
    }

    public static void pastSortIter(int[] arr) {
        for (int border = 1; border < arr.length; border++) {
            for (int position = border; position > 0; position--) {
                if (arr[position] < arr[position - 1]) {
                    int temp = arr[position - 1];
                    arr[position - 1] = arr[position];
                    arr[position] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println("Отсортированный массив итеррационной ВСТАВКОЙ:\n" + Arrays.toString(arr));
    }
}
