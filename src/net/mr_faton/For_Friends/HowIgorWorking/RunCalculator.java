package net.mr_faton.For_Friends.HowIgorWorking;

import java.util.Scanner;

/**
 * Created by Faton on 04.12.2014.
 */
public class RunCalculator {
    public static void main(String[] args) {
        int day;
        int month;
        int year = 2015;
        Scanner in = new Scanner(System.in);
        System.out.println("Введи день:");
        day = in.nextInt();
        System.out.println("Введи месяц:");
        month = in.nextInt();
        System.out.println(new Calculator().calculateDay(day, month, year));
    }
}
