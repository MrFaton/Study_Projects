package net.Horstmann_Example_T1.Chapter6.App02_FirstTestInnerClass;

import javax.swing.*;

/**
 * Created by root on 27.01.2015.
 */
public class ClockTest {
    public static void main(String[] args) {
        TalkingClock myClock = new TalkingClock(5000, true);
        myClock.go();
        JOptionPane.showMessageDialog(null, "Для выхода нажать ОК");
        System.exit(0);
    }
}
