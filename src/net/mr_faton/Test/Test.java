package net.mr_faton.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2015, 5, 10, 20, 47, 53);
        System.out.println(calendar.getTimeInMillis());
    }
}