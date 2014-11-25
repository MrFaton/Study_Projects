package net.mr_faton.OOP.App08_SubtypePolimorphism.NicePainter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 25.11.2014.
 */
public class Test {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();
        figures.add(new CircleMy(2, 3, 10));
        figures.add(new RectMy(35, 40, 8, 15));

        new Painter().drow(figures);
        new Painter().print(figures);
        System.out.println("Минимальная точка по левому краю: " + new Position().minLeft(figures));
    }
}
