package net.mr_faton.Different_Things;

/**
 * Created by Mr_Faton on 17.09.2015.
 */

class A {
    //не статический блок инициализации
    {
        System.out.print("3");
    }

    //статический блок инициализации
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("4");
    }
}

class B extends A {
    {
        System.out.print("5");
    }

    static {
        System.out.print("2");
    }

    public B() {
        System.out.print("6");
    }

    public static void main(String[] args) {
        new B();
    }
}

public class ClassInit {
    public static void main(String[] args) {
        new B();
    }
}
