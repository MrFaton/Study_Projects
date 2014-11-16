package net.mr_faton.OOP.App01_Types01;

/**
 * Created by root on 16.11.2014.
 */
class A {
}

class B extends A {
    void f() {
        System.out.println("Hello!");
    }
}

class Test {
    public static void main(String[] args) {
        B ref = new B();
        ref.f();
    }
}
//Теперь ref() имеет тип В и ссылается она на объект типа В и теперь мы можем использовать метод f()