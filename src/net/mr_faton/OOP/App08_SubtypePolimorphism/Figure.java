package net.mr_faton.OOP.App08_SubtypePolimorphism;

/**
 * Created by Faton on 25.11.2014.
 */
public interface Figure {
    public void drow();//drow - это универсальная штука, это некая абстракция, то есть я не знаю как рисовать эту фигуру, но когда вызываешь метод drow, она сама себя нарисует

    public void print();
}
