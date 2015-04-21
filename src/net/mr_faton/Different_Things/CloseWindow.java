package net.mr_faton.Different_Things;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by root on 21.04.2015.
 */
public class CloseWindow {
    public static JFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Program(mainFrame));
    }
}

class Program implements Runnable {
    private JFrame mainFrame;

    Program(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        mainFrame.setTitle("ГЦСТ Загрузчик метеокарт (by Mr_Faton)");

        //обработчик закрытия окна
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int selection = JOptionPane.showConfirmDialog(mainFrame, "Вы действительно хотите выйти?",
                        "Выход", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.YES_OPTION) {
                    mainFrame.dispose();
                    System.exit(0);
                }
            }
        });

        //поверх других окон на экране
        mainFrame.toFront();
        mainFrame.setVisible(true);


    }
}
class MainFrame extends JFrame {
    private static int MAIN_FRAME_WIDTH = 700;
    private static int MAIN_FRAME_HEIGHT = 500;


    public MainFrame() throws HeadlessException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension monitorScreenSize = toolkit.getScreenSize();
        int monitorWidth = monitorScreenSize.width;
        int monitorHeight = monitorScreenSize.height;

        setSize(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
        setLocation(monitorWidth / 2 - MAIN_FRAME_WIDTH / 2, monitorHeight / 2 - MAIN_FRAME_HEIGHT / 2);
        setResizable(false);

    }
}