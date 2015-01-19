package net.mr_faton.Arrays;

import java.util.Arrays;

/**
 * Created by Mr_Faton on 13.01.2015.
 */
public class ReversArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        System.out.println("Наш массив:\n" + Arrays.toString(arr));

        reversIter(arr);//вызывать нужно с каким-то одним из методов
        System.out.println("Реверсивный итерационный массив:\n" + Arrays.toString(arr));

//        reversRec(arr, 0);
//        System.out.println("Реверсивный рекурсивный массив:\n" + Arrays.toString(arr));
    }

    public static void reversIter(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static void reversRec(int[] arr, int position) {
        if (position < arr.length / 2) {
            int temp = arr[position];
            arr[position] = arr[arr.length - 1 - position];
            arr[arr.length - 1 - position] = temp;
            reversRec(arr, position + 1);
        }
    }
}
