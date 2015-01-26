package net.Horstmann_Example_T1.Chapter5.ReflectTest_App00;

/**
 * Created by Mr_Faton on 26.01.2015.
 */
public class Employee {
    private String name;
    private double balance;
    private int id;

    public Employee(String name, double balance, int id) {
        this.name = name;
        this.balance = balance;
        this.id = id;
    }

    //просто инкреминирует поле balance и поле id на 5
    public void increment() {
        balance += 5;
        id += 5;
    }
}
