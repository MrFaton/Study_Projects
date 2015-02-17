package net.mr_faton.For_Friends.HowIgorWorking;

import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormatSymbols;

/**
 * Created by Faton on 04.12.2014.
 */
public class Calculator {
    private static final int DAY = 1000 * 60 * 60 * 24;
    private static final String[] WHAT_IM_DOING = {"работаю в день", "работаю в ночь", "дома после ночи", "дома перед днём"};

    private static final int numOfWorkDay = 12;
    private static final int numOfWorkMonth = 11;
    private static final int numOfWorkYear = 2014;

    public String calculateDay(int numOfNeedDay, int numOfNeedMonth, int numOfNeedYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(numOfWorkYear, numOfWorkMonth - 1, numOfWorkDay);
        long startDay = calendar.getTimeInMillis();
        calendar.set(numOfNeedYear, numOfNeedMonth - 1, numOfNeedDay);
        long needDay = calendar.getTimeInMillis();
        int days = (int) ((needDay - startDay) / DAY);

        String[] weekDays = new DateFormatSymbols().getWeekdays();

        return "Я " + WHAT_IM_DOING[days % 4] + ". Дата интересующего дня: " + String.format("%td/%<tm/%<tY ", calendar) +
                weekDays[calendar.get(Calendar.DAY_OF_WEEK)];
    }
}
