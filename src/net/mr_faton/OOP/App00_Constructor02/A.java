package net.mr_faton.OOP.App00_Constructor02;

/**
 * Created by Faton on 14.11.2014.
 */
class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    B() {
        System.out.println("B");
    }
}

class C extends B {
    C() {
        System.out.println("C");
    }
}

class Test {
    public static void main(String[] args) {
        new C();

        //или так
        B ref = new C();

        //или так
//        Object ref = new C();
    }
}

/*
Суть в том, что при создании/конструировании объекта С, сначала вызываются конструкторы его предка, т.е. В, а при
конструировании В, вызывается конструктор его предка, т.е. А. И поэтому при создании объекта С в итоге создаётся
объект А, потом объект В и в самом конеце объект С.
 */