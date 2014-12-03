package net.mr_faton.OOP.App17_Enum.App02_Fields;

/**
 * Created by Faton on 03.12.2014.
 */
public enum Planet {
    EARTH(100), MARS(1000), VENUS(10000);

    private double mass;

    Planet(double mass) {
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Planet.EARTH.getMass());
        System.out.println();
    }
}
/*
Чтобы пользоваться значениями, необходимо:
% инициализировать переменные (EARTH(100), MARS(1000), VENUS(10000);)
% установить тип поля (private double mass;)
% добавить конструктор
 */