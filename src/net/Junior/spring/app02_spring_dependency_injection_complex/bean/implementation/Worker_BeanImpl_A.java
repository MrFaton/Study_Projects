package net.Junior.spring.app02_spring_dependency_injection_complex.bean.implementation;

import net.Junior.spring.app02_spring_dependency_injection_complex.bean.Worker_Bean;

/**
 * Created by root on 30.04.2015.
 */
public class Worker_BeanImpl_A implements Worker_Bean {
    @Override
    public void doSomething() {
        String helloStr = "I am the ";
        System.out.println(helloStr + getClass().getSimpleName());
    }

    @Override
    public void printNumber() {
        System.out.println(1);
    }

    @Override
    public void printArrNumbers() {

    }

    @Override
    public void printMap() {

    }

    @Override
    public void printCoordinates() {

    }
}
