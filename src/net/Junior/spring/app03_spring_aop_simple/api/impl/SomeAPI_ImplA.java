package net.Junior.spring.app03_spring_aop_simple.api.impl;

import net.Junior.spring.app03_spring_aop_simple.api.SomeAPI;

/**
 * Created by root on 03.05.2015.
 */
public class SomeAPI_ImplA implements SomeAPI {
    @Override
    public void sayHi() {
        System.out.println("Hi to all");
    }

    @Override
    public void saySomething(String someThing) {
        System.out.println(someThing);
    }

    @Override
    public void echo(String text, int count) {
        doEcho(text, count);
    }

    private void doEcho(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
}
