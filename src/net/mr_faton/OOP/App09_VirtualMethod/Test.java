package net.mr_faton.OOP.App09_VirtualMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faton on 26.11.2014.
 */
public class Test {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Circle(15, 18, 10));
        figures.add(new Circle(38, 24, 5));
        figures.add(new Rect(46, 53, 18, 7));

//        new Figure().left(); //выкинет исключение

        System.out.println(new Position().mostLeft(figures)); //исключения НЕ будет
    }
}
