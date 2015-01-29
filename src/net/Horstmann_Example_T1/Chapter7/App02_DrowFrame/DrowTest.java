package net.Horstmann_Example_T1.Chapter7.App02_DrowFrame;

import javax.swing.*;

/**
 * Created by Mr_Faton on 29.01.2015.
 */
public class DrowTest {
    public static void main(String[] args) {
        JFrame frame = new DrowFrame();
        frame.setTitle("Рисовалка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
