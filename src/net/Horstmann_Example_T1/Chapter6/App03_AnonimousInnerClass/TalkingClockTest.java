package net.Horstmann_Example_T1.Chapter6.App03_AnonimousInnerClass;

import javax.swing.*;

/**
 * Created by root on 27.01.2015.
 */
public class TalkingClockTest {
    public static void main (String[] args) {
        TalkingClock talkingClock = new TalkingClock();
        talkingClock.start(3000, true);

        JOptionPane.showMessageDialog(null, "Нажми для выхода");
    }
}
