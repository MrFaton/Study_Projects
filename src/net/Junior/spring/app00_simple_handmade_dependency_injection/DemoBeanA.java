package net.Junior.spring.app00_simple_handmade_dependency_injection;

/**
 * Created by root on 25.04.2015.
 */
public class DemoBeanA implements DemoBean {
    private int x = 1;
    private int y = 2;
    private String helloStr = "Hello from ";

    public void saySomething() {
        System.out.println(helloStr + getClass().getSimpleName());
    }

    public void printX() {
        System.out.println(x);
    }

    public void printY() {
        System.out.println(y);
    }
}
/*
Реализует интерфейс DemoBean
 */