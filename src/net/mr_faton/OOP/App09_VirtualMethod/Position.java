package net.mr_faton.OOP.App09_VirtualMethod;

import java.util.List;

/**
 * Created by Faton on 26.11.2014.
 */
public class Position {
    public int mostLeft(List<Figure> figures) {
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
