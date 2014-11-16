package net.mr_faton.OOP.App01_Types00;

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
        A ref = new B();
//        ref.f();
    }
}
//Тут сделать ссылку типа А на объект типа В не имело смысла, так как у ref нельзя вызвать метод f()