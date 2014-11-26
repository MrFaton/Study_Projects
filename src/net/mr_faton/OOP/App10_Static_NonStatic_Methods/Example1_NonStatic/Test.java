package net.mr_faton.OOP.App10_Static_NonStatic_Methods.Example1_NonStatic;

/**
 * Created by Faton on 26.11.2014.
 */
public class Test {
    public static void main(String[] args) {
        Parent ref0 = new Child();
        ref0.f();

        Child ref1 = new Child();
        ref1.f();
    }
}
/*
Когда вызываем метод f() у ссылки ref0, то мы вызываем метод f() у Child-а благодаря оверрайдингу.
Когда вызываем метод f() у ссылки ref1, то мы вызываем метод f() у Child-а так как ref1 - типа Child
 */