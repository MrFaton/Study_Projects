package net.Horstmann_Example_T1.Chapter6.App01_ActionListnerTest;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormatSymbols;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Created by root on 27.01.2015.
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new MyTimer();
        Timer timer = new Timer(5000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null, "Для выхода нажать ОК");
        System.exit(0);
    }
}

class MyTimer implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        String[] weekDays = new DateFormatSymbols().getWeekdays();
        String[] month = new DateFormatSymbols().getMonths();
        GregorianCalendar now = new GregorianCalendar();
        System.out.print("Сегодня " + now.get(Calendar.DAY_OF_MONTH) + " ");
        System.out.print(month[now.get(Calendar.MONTH)] + " " + weekDays[now.get(Calendar.DAY_OF_WEEK)] + " ");
        System.out.print(now.get(Calendar.HOUR) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND) + "\n");

        Toolkit.getDefaultToolkit().beep();
    }
}
