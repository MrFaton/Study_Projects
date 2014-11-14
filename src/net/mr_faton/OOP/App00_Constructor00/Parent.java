package net.mr_faton.OOP.App00_Constructor00;

/**
 * Created by Faton on 14.11.2014.
 */
class Parent extends Object {
//    Parent (int k){
//        super();
//    }
}

class Child extends Parent {
//    Child() {
//        super();
//    }
}
/*Не компилируется, т.к. конструктор по умолчанию Child вызывает конструктор без аргументов Parent, а там такого
конструктора нет
*/