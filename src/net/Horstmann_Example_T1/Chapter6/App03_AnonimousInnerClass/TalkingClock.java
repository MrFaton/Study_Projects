package net.Horstmann_Example_T1.Chapter6.App03_AnonimousInnerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

/**
 * Created by root on 27.01.2015.
 */
public class TalkingClock {
    public void start(int interval, final boolean beep){
        //создаём анонимный класс, который реализует интерфейс ActionListener и его метод actionPerformed
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("Time is now " + now);

                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };

        Timer timer = new Timer(interval, listener);
        timer.start();
    }
}
/*
Локальный анонимный вложенный класс получается тогда, когда за собками со писком необходимых парамтров для создания
экземпляра класс следует открывающаяся фигурная скобка. Н:
ActionListener listener = new ActionListener() {...} - в фигурных скобках - анонимный вложенный класс
или
new Thread(new Runnable() {...}) - в фигурных скобках - анонимный вложенный класс.

Анонимный вложенный класс может оперировать локальными переменными. Но они должны быть финальными. Дело в том, что
внутренний класс (анонимный или нет - не важно) может оперировать этими переменными, но метод, в котором находится
внутренний класс, запускает в работу этот класс, а сам завершается и в месте с ним уничтожаются и его локальные
переменные. Чтобы вложенный класс мог ими оперировать, он делает себе копии этих переменных. И для того, чтобы
гарантировать, что копия во внутреннем классе будет соответствовать оригинальной локальной переменной в методе, она
обязанна быть финальной. Тот случай, когда объявляется финальный массив на одну ячейку, а потом мы можем изменять
значение в этой ячейке.
 */