package net.mr_faton.OOP.App07_Super;

/**
 * Created by Faton on 19.11.2014.
 */
class Parent {
    void f() {
        System.out.println("Это метод родителя");
    }
}

class Child extends Parent {
    void f() {
        super.f();//Единстенный способ вызвать метод пердка
        System.out.println("Это метод потомка");
    }
}

class Test {
    public static void main(String[] args) {
        Parent ref = new Child();
        ref.f();
    }
}
/*
Единственный вариант использования "super.". Это всё используется для вызова метода именно предка,
а не переопределённого метода потомка.
 */