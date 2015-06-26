package net.mr_faton.Arrays.Sort;

import java.util.Arrays;

/**
 * Created by Mr_Faton on 13.01.2015.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr0 = createArr(6);
        int[] arr1 = createArr(10);
        printArr("arr0", arr0);
        printArr("arr1", arr1);
        System.out.println();

        sortArr(arr0);
        sortArr(arr1);
        printArr("Sorted arr0", arr0);
        printArr("Sorted arr1", arr1);
        System.out.println();

        int[] myArr = makeMergeArr(arr0, arr1);
        printArr("Merged arr", myArr);

    }

    public static int[] createArr(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length - 1; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    public static void sortArr(int[] arr) {
        for (int x = arr.length - 1; x >= 0; x--) {
            for (int i = 0; i < x; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void printArr(String str, int[] arr) {
        System.out.println(str + ":\n" + Arrays.toString(arr));
    }

    public static int[] makeMergeArr(int[] arr0, int[] arr1) {
        int[] makedArr = new int[arr0.length + arr1.length];

        int indexA = 0;
        int indexB = 0;

        while ((indexA + indexB) != makedArr.length) {
            if (arr0[indexA] < arr1[indexB]) {
                makedArr[indexA + indexB] = arr0[indexA++];
            } else {
                makedArr[indexA + indexB] = arr1[indexB++];
            }

            if (indexA == arr0.length) {
                System.arraycopy(arr1, indexB, makedArr, indexA + indexB, arr1.length - indexB);
                break;
            } else if (indexB == arr1.length) {
                System.arraycopy(arr0, indexA, makedArr, indexA + indexB, arr0.length - indexA);
                break;
            }
        }

        return makedArr;
    }
}
/*
Есть 2 массива, из них нужно получить третий - отсортированный.
Для этого мы сначала должны отсортировать два исходных массива.
 */