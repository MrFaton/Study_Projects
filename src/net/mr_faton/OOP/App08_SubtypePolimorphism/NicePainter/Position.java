package net.mr_faton.OOP.App08_SubtypePolimorphism.NicePainter;

import java.util.List;

/**
 * Created by Faton on 25.11.2014.
 */
public class Position {
    public int minLeft(List<Figure> figures) {
        if (figures.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int min = figures.get(0).left();
        for (int k = 1; k < figures.size(); k++) {
            min = Math.min(min, figures.get(k).left());
        }
        return min;
    }
}
