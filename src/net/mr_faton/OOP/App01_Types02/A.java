package net.mr_faton.OOP.App01_Types02;

/**
 * Created by root on 16.11.2014.
 */
class A {
}

class B extends A {
}

class C extends B {
}

class Test {
    public static void main(String[] args) {
        fun("Hello!");
        fun(new Integer(3));
        fun(new B());
        fun(new C());
        fun(new int[]{0, 5, 2});
    }

    public static void fun(Object ref) {
        System.out.println("ref: " + ref.toString());
    }
}
/*
Чтобы наш метод fun() смог работать со всеми типами, которые приведены выше, мы должны указать ему общего предка.
У этих всех сущностей один общий предок - Object. Теперь наш метод f() полиморфен
(это походу полиморфизм на наследовании).
 */