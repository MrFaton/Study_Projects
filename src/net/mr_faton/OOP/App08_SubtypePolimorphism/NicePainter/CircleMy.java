package net.mr_faton.OOP.App08_SubtypePolimorphism.NicePainter;

/**
 * Created by Faton on 25.11.2014.
 */
public class CircleMy implements Figure {
    public int x;
    public int y;
    public int radius;

    public CircleMy(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void drow() {
        System.out.println("Рисуем круг с радиусом: " + radius);
    }

    @Override
    public void print() {
        System.out.println("Печатаем круг с радиусом: " + radius);
    }

    @Override
    public int left() {
        return x - radius;
    }
}
