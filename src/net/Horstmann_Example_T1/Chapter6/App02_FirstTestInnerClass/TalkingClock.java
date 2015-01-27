package net.Horstmann_Example_T1.Chapter6.App02_FirstTestInnerClass;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 * Created by root on 27.01.2015.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void go() {
        /*
        * создаём экземпляр класса-слушателя, который реализовывает интерфейс ActionListener, в котором находится
        * реализация тех действий, которые должен выполнить таймер по истечению времени ожидания
        * */
        ActionListener listener = new TimePrinter();
        /*создаём объект таймера и передаём ему интервал и экземпляр класса слушателя, в котором храняться действия,
        * нужные к выполнению
        * */
        Timer timer = new Timer(interval, listener);
        //стартуем таймер
        timer.start();
    }

    /*
     * класс TimePrinter реализовывает интерйейс ActionListener, а в нём метод actionPerformed, в котором хранятся
     * действия, которые необходимо выполнить таймеру по истечению определённого времени. Этот класс имеет доступ
     * ко всем приватным полями и методома своего объемлюющего класс - TalkingClock. Класс TimePrinter может быть
     * объявлен с любым модификатором доступа. Приват означает, что о существовании этого класса знает только
     * объемлюющий класс
     */
    public class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Date now = new Date();
            System.out.println("Time is now: " + now);

            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
