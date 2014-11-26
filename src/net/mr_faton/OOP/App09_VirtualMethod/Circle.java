package net.mr_faton.OOP.App09_VirtualMethod;

/**
 * Created by Faton on 26.11.2014.
 */
public class Circle extends Figure {
    public int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int left() {
        return x - radius;
    }
}
