package net.Horstmann_Example_T1.Chapter7.App00_SimpleFrame;

import javax.swing.JFrame;

/**
 * Created by Mr_Faton on 27.01.2015.
 */
public class SimpleFrame extends JFrame {
    private static final int DEFAULT_WEIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WEIDTH, DEFAULT_HEIGHT);
    }
}
