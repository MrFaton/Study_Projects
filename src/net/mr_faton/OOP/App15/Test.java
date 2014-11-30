package net.mr_faton.OOP.App15;

/**
 * Created by Faton on 30.11.2014.
 */
public class Test {
    public static void main(String[] args) {
        RadioButton rb0 = new RadioButton(7, 9);
        RadioButton rb1 = new RadioButton(60, 71);

        System.out.println(rb0.getOn() + " : " + rb1.getOn());

        Mouse.addListener(rb0);
        Mouse.addListener(rb1);

        Mouse.click(10, 10);

        System.out.println(rb0.getOn() + " : " + rb1.getOn());
    }
}
