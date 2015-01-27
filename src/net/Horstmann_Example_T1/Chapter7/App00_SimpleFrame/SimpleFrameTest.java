package net.Horstmann_Example_T1.Chapter7.App00_SimpleFrame;

import javax.swing.JFrame;
import java.awt.EventQueue;

/**
 * Created by Mr_Faton on 27.01.2015.
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame frame = new SimpleFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                System.out.println("Работаем в потоке - " + Thread.currentThread().getName());
            }
        });
        System.out.println("поток main завершился - " + Thread.currentThread().getName());
    }
}
