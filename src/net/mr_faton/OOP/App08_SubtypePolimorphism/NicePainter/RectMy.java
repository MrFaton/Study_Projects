package net.mr_faton.OOP.App08_SubtypePolimorphism.NicePainter;

/**
 * Created by Faton on 25.11.2014.
 */
public class RectMy implements Figure {
    public int centrX;
    public int centrY;
    public int weight;
    public int height;

    public RectMy(int centrX, int centrY, int weight, int height) {
        this.centrX = centrX;
        this.centrY = centrY;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public void drow() {
        System.out.println("Рисуем прямоугольник с высотой: " + height);
    }

    @Override
    public void print() {
        System.out.println("Печатаем прямоугольник с высотой: " + height);
    }

    @Override
    public int left() {
        return centrX - height / 2;
    }
}
