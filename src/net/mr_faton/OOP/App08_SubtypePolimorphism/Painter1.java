package net.mr_faton.OOP.App08_SubtypePolimorphism;

import java.util.List;

/**
 * Created by Faton on 25.11.2014.
 */
public class Painter1 {
    public void drow(List<Figure> figures) {
        for (Figure fig : figures) {
            fig.drow();
        }
    }
}
