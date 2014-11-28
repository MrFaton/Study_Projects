package net.mr_faton.OOP.App12_Nested_classes.App0_Named_rules;

import static net.mr_faton.OOP.App12_Nested_classes.App0_Named_rules.App0.Nested;

/**
 * Created by root on 28.11.2014.
 */
public class App0 {
    static public class Nested {
    }
}

class Test {
    public static void main(String[] args) {
        App0.Nested ref = new App0.Nested();//можно создавать nested class по не полному имени
        net.mr_faton.OOP.App12_Nested_classes.App0_Named_rules.App0.Nested ref1 = new net.mr_faton.OOP.App12_Nested_classes.App0_Named_rules.App0.Nested();//можно создавать nested class по полному имени
        Nested ref3 = new Nested();//так можно делать только со статичекским импортом класса (import static в верху)
    }
}