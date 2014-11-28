package net.mr_faton.OOP.App12_Nested_classes.App1_Encapsulation;

/**
 * Created by root on 28.11.2014.
 */
public class App1 {
    private int k = 0;
    private int p = k + 1;

    static public class Nested {
        public void f() {
            System.out.println("k= " + new App1().k + " p= " + new App1().p);//работает, потому что мы находимся в одних фигурных скобках с приватными полями
        }
    }
}

class Test {
    public static void main(String[] args) {
//        System.out.println("k= " + new App1().k + " p= " + new App1().p);//работать НЕ будет, так как мы снаружи пытаемся почесть закрытые/приватные поля

        new App1.Nested().f();//работает, это ужасно, мы через вложенный класс читаем закрытые/приватные поля!
    }
}
/*
Сломаная инкапсуляция.
 */