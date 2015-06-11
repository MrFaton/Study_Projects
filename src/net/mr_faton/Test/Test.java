package net.mr_faton.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
//        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 14);


        System.out.println(String.format("Calendar: %td : %<tm : %<tY | %<tH : %<tM", calendar));
    }
}