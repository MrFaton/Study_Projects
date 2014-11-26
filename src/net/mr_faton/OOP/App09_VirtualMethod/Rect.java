package net.mr_faton.OOP.App09_VirtualMethod;

/**
 * Created by Faton on 26.11.2014.
 */
public class Rect extends Figure {
    public int x, y, weight, height;

    public Rect(int x, int y, int weight, int height) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
    }

    public int left() {
        return x - weight / 2;
    }
}
