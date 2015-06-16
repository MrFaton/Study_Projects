package net.mr_faton.test;


import java.math.BigInteger;
import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int x = 100;
        BigInteger factorial = getFactorial(x);
        System.out.println("factorial: " + factorial);
        int[] intFactorialArray = getIntArray(factorial);
        System.out.println("int arr: " + Arrays.toString(intFactorialArray));
        int sum = getSumOfDigits(intFactorialArray);
        System.out.println("sum: " + sum);
    }

    private static BigInteger getFactorial(int x) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= x; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static int[] getIntArray(BigInteger factorial) {
        String factorialStr = factorial.toString();
        int[] factorialArr = new int[factorialStr.length()];
        for (int i = 0; i < factorialStr.length(); i++) {
            factorialArr[i] = Integer.valueOf(factorialStr.charAt(i) + "");
        }
        return factorialArr;
    }

    private static int getSumOfDigits(int[] intFactorialArray) {
        int sum = 0;
        for (int digit : intFactorialArray) {
            sum += digit;
        }
        return sum;
    }
}