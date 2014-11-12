package net.mr_faton.Different_Things;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by root on 12.11.2014.
 */
public class MyWorkDays {
    static final int DAY=1000*60*60*24;
    static final String[] WHAT_IM_DOING = {"работаю в день", "работаю в ночь", "дома после ночи", "дома перед днём"};

    //день месяца и месяц, когда я хочу узнать статус своей работы
    static int numOfNeedDay = 1;
    static int numOfNeedMonth = 4;
    static int numOfNeedYear = 2015;

    //Когда я последний раз работал в ДЕНЬ!??
    static int numOfWorkDay = 3;
    static int numOfWorkMonth = 1;
    static int numOfWorkYear = 2015;

    public static void main(String[] args) {
        


        Calendar calendar = Calendar.getInstance();
        calendar.set(numOfWorkYear, numOfWorkMonth-1, numOfWorkDay, 10, 0);
        long startDay = calendar.getTimeInMillis();
        calendar.set(numOfNeedYear, numOfNeedMonth - 1, numOfNeedDay, 10, 0);
        long needDay = calendar.getTimeInMillis();

        int days =(int) ((needDay - startDay)/DAY);

        for (int i = 0; i<days; i++){
            startDay +=DAY;
        }
        calendar.setTimeInMillis(startDay);
        System.out.println(String.format("%tc", calendar));

//        int q = days/4;
//        int w = q*4;
//        long e = (long) w*DAY + startDay;
//

    }
}
