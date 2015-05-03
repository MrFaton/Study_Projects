package net.Junior.spring.app02_spring_dependency_injection_complex.bean.implementation;

import net.Junior.spring.app02_spring_dependency_injection_complex.bean.Worker_Bean;

import java.util.Map;

/**
 * Created by root on 30.04.2015.
 */
public class Worker_Bean_ImplA implements Worker_Bean {
    private final int x;
    private final int y;
    private int[] arrNumbers;
    private Map<String, String> map;

    //для объекта этого класса необходимы аргументы конструктора
    public Worker_Bean_ImplA(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void doSomething() {
        String helloStr = "Hello I am the ";
        System.out.println(helloStr + getClass().getSimpleName());
    }

    @Override
    public void printNumber() {
        System.out.println("My number is: " + 1);
    }

    @Override
    public void printArrNumbers() {
        System.out.println("Print ArrNumbers:");
        for (int current : arrNumbers) {
            System.out.println(current);
        }
        System.out.println("*****");
    }

    @Override
    public void printMap() {
        System.out.println("Print Map:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("*****");
    }

    @Override
    public void printCoordinates() {
        System.out.println("Print Coordinates:");
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("*****");
    }

    //так же объект класса будет содержать уникальные поля, которые необходимо установить сеттерами
    public void setArrNumbers(int[] arrNumbers) {
        this.arrNumbers = arrNumbers;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
/*
Первый вариант реализации интерфейса Worker_Bean.
Содержит в себе конструктор и сеттеры, которые определяются в конфигурационном xml-е
 */