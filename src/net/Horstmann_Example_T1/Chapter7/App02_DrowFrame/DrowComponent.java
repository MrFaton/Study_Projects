package net.Horstmann_Example_T1.Chapter7.App02_DrowFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Mr_Faton on 29.01.2015.
 */
public class DrowComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //можно рисовать с мопощью конкретных точек
        double leftX = 100;
        double leftY = 150;
        double width = 200;
        double height = 125;


        Rectangle2D rectangle2D = new Rectangle2D.Double(leftX, leftY, width, height);
        g2.draw(rectangle2D);

        Ellipse2D ellipse2D = new Ellipse2D.Double();
        ellipse2D.setFrame(rectangle2D);
        g2.draw(ellipse2D);

        Line2D line2D = new Line2D.Double(leftX, leftY, leftX + width, leftY + height);
        g2.draw(line2D);
        //линию ещё можно нарисовать так
        Point2D point1 = new Point2D.Double(10, 10);
        Point2D point2 = new Point2D.Double(40, 80);
        Line2D line2 = new Line2D.Double(point1, point2);
        g2.draw(line2);

        double centrX = rectangle2D.getCenterX();
        double centrY = rectangle2D.getCenterY();
        double radius = 150;
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centrX, centrY, centrX + radius, centrY + radius);
        g2.draw(circle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
