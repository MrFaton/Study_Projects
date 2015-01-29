package net.Horstmann_Example_T1.Chapter7.App01_SizedFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mr_Faton on 29.01.2015.
 */
public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SizedFrame();
                frame.setTitle("Тест окно");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
