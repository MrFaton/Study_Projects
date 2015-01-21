package net.mr_faton.Test;


import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        GregorianCalendar cal = new GregorianCalendar();
//        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
//        cal.set(Calendar.DAY_OF_MONTH, 1);
//        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
//        System.out.println(cal.getFirstDayOfWeek());
        String[] days = new DateFormatSymbols().getShortWeekdays();
        System.out.println(days[cal.get(Calendar.DAY_OF_WEEK)]);
    }
}