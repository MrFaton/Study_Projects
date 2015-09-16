package net.mr_faton.Different_Things.task;

import java.util.Arrays;

/**
 * Created by root on 16.09.2015.
 */
public class DelNumFromArr {
    public static void main(String[] args) {
        int num = 5;
        System.out.println("del num: " + num);
        int[] arr = {2, 5, 4, 9, 0, 5, 6, 8};
        System.out.println("source arr " + Arrays.toString(arr));
        System.out.println("source arr length " + arr.length);
        int[] resultArr = delNum(num, arr);
        System.out.println("result arr " + Arrays.toString(resultArr));
        System.out.println("result arr length " + resultArr.length);
    }
    private static int[] delNum(int num, int[] arr) {
        int[] updatedArr = new int[arr.length];
        int updatedArrNum = 0;
        int totalDel = 0;
        for (int cur : arr) {
            if (cur == num) {
                totalDel++;
                continue;
            }
            updatedArr[updatedArrNum++] = cur;
        }
        int[] resultArr = new int[updatedArr.length - totalDel];
        System.arraycopy(updatedArr, 0, resultArr, 0, updatedArr.length - totalDel);
        return resultArr;
    }
}
