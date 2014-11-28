package net.mr_faton.OOP.App12_Nested_classes;

/**
 * Created by root on 28.11.2014.
 */
public class App2 {
    public App2() {
        System.out.println("App2 Hello!");
    }

    static public class Nested0 {
        public Nested0() {
            System.out.println("Nested0 Hello!");
        }

        static public class Nested1 {
            public Nested1() {
                System.out.println("Nested1 Hello!");
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        new App2.Nested0.Nested1();
        System.out.println("******");
        new App2.Nested0();
        System.out.println("******");
        new App2();

    }
}
/*
Как видим при создании экземпляра Nested1 экземпляры классов Nested0 и App2 не создаются. То есть
классы App2, Nested0 и Nested1 - абсолютно независимы штуки. Их независимость прявляется через: имя, nested сущности
находятся на том же уровне инкапсуляции что и приватные поля и методы объемлюющего класса.
 */