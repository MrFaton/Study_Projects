package net.mr_faton.Different_Things;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by root on 14.12.2014.
 */
public class MobileCalculatorWorkDays {
    static final int DAY = 1000 * 60 * 60 * 24;
    static final String[] WHAT_IM_DOING = {"работаю в день", "работаю в ночь", "дома после ночи", "дома перед днём"};

    static int numOfWorkDay = 12;
    static int numOfWorkMonth = 11;
    static int numOfWorkYear = 2014;

    public static void main(String[] args) {
        int numOfNeedDay = 0;
        int numOfNeedMonth = 0;
        int numOfNeedYear = 0;
        System.out.println("Вводим дату");

        try {
            numOfNeedDay = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            numOfNeedMonth = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            numOfNeedYear = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(numOfWorkYear, numOfWorkMonth - 1, numOfWorkDay);
        long startDay = calendar.getTimeInMillis();
        calendar.set(numOfNeedYear, numOfNeedMonth - 1, numOfNeedDay);
        long needDay = calendar.getTimeInMillis();
        int days = (int) ((needDay - startDay) / DAY);

        System.out.println(WHAT_IM_DOING[days % 4] + ". А это у нас " + String.format("%tc", calendar));
    }
}
