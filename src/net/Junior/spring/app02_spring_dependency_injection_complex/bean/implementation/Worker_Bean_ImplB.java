package net.Junior.spring.app02_spring_dependency_injection_complex.bean.implementation;

import net.Junior.spring.app02_spring_dependency_injection_complex.bean.Worker_Bean;

import java.util.Map;

/**
 * Created by root on 30.04.2015.
 */
public class Worker_Bean_ImplB implements Worker_Bean {
    private String str1 = "This is method ";
    private String str2 = " and I don't know how it's work";

    @Override
    public void doSomething() {
        String helloStr = "Hello I am the ";
        System.out.println(helloStr + getClass().getSimpleName());
    }

    @Override
    public void printNumber() {
        System.out.println(str1 + "printNumber()" + str2);
    }

    @Override
    public void printArrNumbers() {
        System.out.println(str1 + "printArrNumbers()" + str2);
    }

    @Override
    public void printMap() {
        System.out.println(str1 + "printMap()" + str2);
    }

    @Override
    public void printCoordinates() {
        System.out.println(str1 + "printCoordinates()" + str2);
    }
}
/*
Вторая реализация интерфейса Worker_Bean. Она более упрощённая, так как не содержит в себе ни конструкторов ни сеттеров
 */