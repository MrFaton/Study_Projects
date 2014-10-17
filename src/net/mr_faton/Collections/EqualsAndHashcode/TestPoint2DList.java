package net.mr_faton.Collections.EqualsAndHashcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17.10.2014.
 */
public class TestPoint2DList {
    public static void main(String[] args) {
        List<Point2D> list = new ArrayList<>();
        list.add(new Point2D(0, 0));//Добавляем объект Поинт без создания на негоссылки типа Point2D point = new Point2D(0,0)- т.е, можно так не делать
        System.out.println(list);
        System.out.println(list.contains(new Point2D(0, 0)));//точно так можно и проверять, есть ли объект в листе, просто создавтакой же объект
        System.out.println(list.remove(new Point2D(0, 0)));//должен по идее удалить только первый попавшийся элемент, но не остальные элементы
//        while (list.remove(new Point2D(0, 0)));//должен удалить все элементы всписке

        //эти методы будут работать, только если переопределить метод equals в классе, который будем сравнивать, тут в (Poidnt2D)!
    }
}
