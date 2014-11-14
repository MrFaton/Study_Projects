package net.mr_faton.OOP.App00_Constructor03;

/**
 * Created by Faton on 14.11.2014.
 */
class A {
    A() {
        System.out.println("A");
    }

    void f() {
        System.out.println("A.f");
    }
}

class B extends A {
    B() {
        System.out.println("B");
    }

    void f() {
        System.out.println("B.f");
    }
}

class C extends B {
    C() {
        System.out.println("C");
    }

    void f() {
        System.out.println("C.f");
    }
}

class Test {
    public static void main(String[] args) {
        B ref0 = new C();
        A ref1 = ref0;
        ref1.f();
    }
}