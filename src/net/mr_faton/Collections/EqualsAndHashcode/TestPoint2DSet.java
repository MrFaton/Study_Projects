package net.mr_faton.Collections.EqualsAndHashcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 17.10.2014.
 */
public class TestPoint2DSet {
    public static void main(String[] args) {
        Set<Point2D> set = new HashSet<>();
        set.add(new Point2D(1, 1));
        set.add(new Point2D(1, 1));
        System.out.println(set);
        System.out.println(set.contains(new Point2D(1, 1)));
        System.out.println(set.remove(new Point2D(1, 1)));
        System.out.println(set);
    }
}
//HashSet будет коректным и правильно работать только в том случает, когда в классе Point2D переопределён метод hashCode.