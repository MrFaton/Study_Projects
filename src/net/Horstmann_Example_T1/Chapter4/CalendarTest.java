package net.Horstmann_Example_T1.Chapter4;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Mr_Faton on 21.01.2015.
 */
public class CalendarTest {
    public static void main(String[] args) {
        //получаем текущую дату
        GregorianCalendar gcalendar = new GregorianCalendar();
        int today = gcalendar.get(Calendar.DAY_OF_MONTH);
        int month = gcalendar.get(Calendar.MONTH);

        //получить колличество пробелов для первой строки
        gcalendar.set(Calendar.DAY_OF_MONTH, 1);
        int dayOfMonthName = gcalendar.get(Calendar.DAY_OF_WEEK);
        int firstDayOfWeek = gcalendar.getFirstDayOfWeek();
        int spaces = 0;
        while (dayOfMonthName != firstDayOfWeek) {
            spaces++;
            gcalendar.add(Calendar.DAY_OF_MONTH, -1);
            dayOfMonthName = gcalendar.get(Calendar.DAY_OF_WEEK);
        }

        //получить и распечатать сокращённое название дней недели
        String[] weekDays = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekDays[dayOfMonthName]);
            gcalendar.add(Calendar.DAY_OF_MONTH, 1);
            dayOfMonthName = gcalendar.get(Calendar.DAY_OF_WEEK);
        } while (dayOfMonthName != firstDayOfWeek);
        System.out.println();

        //распечатать дни недели календаря

        //печатаем пробелы до первого дня месяца
        gcalendar.set(Calendar.DAY_OF_MONTH, 1);
        for (int i = 0; i < spaces; i++) {
            System.out.printf("    ");
        }
        //печатаем дни
        int day;
        String outStr;
        while (gcalendar.get(Calendar.MONTH) == month) {
            //проверяем на совпадение с сегоднешним днём
            day = gcalendar.get(Calendar.DAY_OF_MONTH);
            if (day != today) {
                outStr = day + " ";
            } else {
                outStr = day + "\u2714";
            }
            System.out.printf("%4s", outStr);
            //добавляем ещё один день
            gcalendar.add(Calendar.DAY_OF_MONTH, 1);
            if (gcalendar.get(Calendar.DAY_OF_WEEK) == firstDayOfWeek) {
                System.out.println();
            }
        }
        System.out.println("\nПосвятим Алине Кахидзе :-)");
    }
}
