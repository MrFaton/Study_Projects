package net.Horstmann_Example_T1.Chapter7.App01_SizedFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mr_Faton on 29.01.2015.
 */
public class SizedFrame extends JFrame {
    public SizedFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWeidth = screenSize.width;
        int screenHeight = screenSize.height;

        setSize(screenWeidth / 3, screenHeight / 3);
        setLocationByPlatform(true);

        Image img = new ImageIcon("D:\\Java\\Study_Projects\\src\\net\\Horstmann_Example_T1\\Chapter7\\App01_SizedFrame\\star.ico").getImage();
        setIconImage(img);
    }
}
