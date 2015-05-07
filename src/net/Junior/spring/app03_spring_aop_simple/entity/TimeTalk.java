package net.Junior.spring.app03_spring_aop_simple.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 07.05.2015.
 */
public class TimeTalk {
    public void sayTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMMM yyyy");

        System.out.println("Current date is " + dateFormat.format(new Date()));
    }
}
/*
Этот класс инициируется вручную, без спринга. Единственная задача этого класса - вывести дату и показать, что перехват
методов доступен только в тех случаях, когда бин построен спрингом
 */