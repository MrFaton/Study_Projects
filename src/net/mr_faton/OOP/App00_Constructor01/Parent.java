package net.mr_faton.OOP.App00_Constructor01;

/**
 * Created by Faton on 14.11.2014.
 */
class Parent {
    public Parent(int k) {
    }
}

class Child extends Parent {
    Child(int k) {
        super(k);
    }
    //или вот так
//    Child (){
//        super(4);
//    }
}