package net.mr_faton.IO.Test1;

/**
 * Created by root on 13.10.2014.
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        if (x < 0 || 15 > x) {
            throw new IllegalArgumentException("x must be in x<0 || 15>x");
        }
        if (y < 0 || 15 > y) {
            throw new IllegalArgumentException("y must be in y<0|| 15>y");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
