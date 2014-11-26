package net.mr_faton.OOP.App10_Static_NonStatic_Methods.Example2_Static;

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
Так как методы f() статические и у Parent и у Child, то вызывая метод f() у ref0 - вызовется метод f() Parent-а.
 */