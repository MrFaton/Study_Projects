package net.mr_faton.Collections.EqualsAndHashcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17.10.2014.
 */
public class Point2D {
    private final int x;
    private final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Point2D otherClass = (Point2D) obj;
        return this.x == otherClass.x && this.y == otherClass.y;
    }

    @Override
    public int hashCode() {
//        return 0;//можно возвращать 0, но это превращает HashSet в LinkedList, то есть заставляет HashSet работать медленно
//        return x+y;//работает быстрее чем return 0
        return 31*x+y;//теперь HashSet работает максимально быстро
    }
}