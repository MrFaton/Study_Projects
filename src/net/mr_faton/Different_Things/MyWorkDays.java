package net.mr_faton.Different_Things;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by root on 12.11.2014.
 */
public class MyWorkDays {
    static final int DAY = 1000 * 60 * 60 * 24;
    static final String[] WHAT_IM_DOING = {"работаю в день", "работаю в ночь", "дома после ночи", "дома перед днём"};

    //день месяца и месяц, когда я хочу узнать статус своей работы
    static int numOfNeedDay = 25;
    static int numOfNeedMonth = 12;
    static int numOfNeedYear = 2014;

    //Когда я последний раз работал в ДЕНЬ!??
    static int numOfWorkDay = 12;
    static int numOfWorkMonth = 11;
    static int numOfWorkYear = 2014;

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(numOfWorkYear, numOfWorkMonth - 1, numOfWorkDay);
        long startDay = calendar.getTimeInMillis();
        calendar.set(numOfNeedYear, numOfNeedMonth - 1, numOfNeedDay);
        long needDay = calendar.getTimeInMillis();
        int days = (int) ((needDay - startDay) / DAY);

        System.out.println(String.format("%tc", calendar));
        System.out.println(WHAT_IM_DOING[days % 4]);
    }
}
