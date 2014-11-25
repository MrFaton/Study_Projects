package net.mr_faton.OOP.App08_SubtypePolimorphism.NicePainter;

import java.util.List;

/**
 * Created by Faton on 25.11.2014.
 */
public class Painter {
    public void drow(List<Figure> figures) {
        for (Figure fig : figures) {
            fig.drow();
        }
    }

    public void print(List<Figure> figures) {
        for (Figure fig : figures) {
            fig.print();
        }
    }

    public int minLeft(List<Figure> figures) {
        return 0;
    }

}
