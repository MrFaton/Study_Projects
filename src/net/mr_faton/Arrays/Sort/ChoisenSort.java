package net.mr_faton.Arrays.Sort;

import java.util.Arrays;

/**
 * Created by Mr_Faton on 13.01.2015.
 */
public class ChoisenSort {
    public static void main(String[] args) {
        int[] data = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = (int) (Math.random() * 10);
        }
        System.out.println("Наш массив:\n" + Arrays.toString(data));
        choisenSortIter(data);
    }

    public static void choisenSortIter(int[] arr) {
        int minElement;
        int tmp;
        boolean isChanged = false;
        for (int i = 0; i < arr.length - 1; i++) {
            minElement = i;
            for (int k = i; k < arr.length - 1; k++) {
                if (arr[minElement] > arr[k + 1]) {
                    minElement = k + 1;
                    isChanged = true;
                }
            }
            if (isChanged) {
                tmp = arr[i];
                arr[i] = arr[minElement];
                arr[minElement] = tmp;
                isChanged = false;
            }
        }
        System.out.println("Отсортированный массив итеррационной ВЫБОРКОЙ:\n" + Arrays.toString(arr));
    }
}
