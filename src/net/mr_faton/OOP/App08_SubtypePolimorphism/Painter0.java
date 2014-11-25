package net.mr_faton.OOP.App08_SubtypePolimorphism;

import java.util.List;

/**
 * Created by Faton on 25.11.2014.
 */
public class Painter0 {
    public void drow(List<Object> figures) { //тут берём лист Object-ов, потому что мы хотим чтобы наш метод работал не только с кругами и прямоугольниками, но и с различными другими фигурами в будущем
        for (Object fig : figures) {
            if (fig instanceof Circle0) {
                Circle0 c = (Circle0) fig;
                System.out.println("Рисуем круг с радиусом: " + c.radius);
            } else if (fig instanceof Rect0) {
                Rect0 r = (Rect0) fig;
                System.out.println("Рисуем прямоугольник с центром Х: " + r.centrX);
            } else {
                throw new IllegalArgumentException("Это не круг и не прямоугольик");
            }
        }
    }
}
