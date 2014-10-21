package net.mr_faton.Collections.EqualsAndHashcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by root on 21.10.2014.
 */
public class TestPoint2DTreeSet {
    public static void main(String[] args) {
        Set<Point2D> set = new TreeSet<>();
        set.add(new Point2D(0, 10));
        set.add(new Point2D(10, 0));
        set.add(new Point2D(0, 10));
        System.out.println(set);
    }
}
