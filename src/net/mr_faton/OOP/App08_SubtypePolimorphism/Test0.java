package net.mr_faton.OOP.App08_SubtypePolimorphism;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 25.11.2014.
 */
public class Test0 {
    public static void main(String[] args) {
        List<Object> figures = new ArrayList<>();
        figures.add(new Circle0(10, 15, 45));
        figures.add(new Circle0(3, 1, 80));
        figures.add(new Rect0(4, 9, 55, 30));

        new Painter0().drow(figures);
    }
}
