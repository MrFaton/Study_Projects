package net.mr_faton.OOP.App15_Listener;

/**
 * Created by Faton on 30.11.2014.
 */
public class Test {
    public static void main(String[] args) {
        RadioButton rb0 = new RadioButton(7, 9);
        RadioButton rb1 = new RadioButton(60, 71);
        RadioButton rb2 = new RadioButton(110, 93);

        rb0.addClickedListener(rb1);
        rb0.addClickedListener(rb2);
        rb1.addClickedListener(rb0);
        rb1.addClickedListener(rb2);
        rb2.addClickedListener(rb0);
        rb2.addClickedListener(rb1);

        System.out.println(rb0.getOn() + " : " + rb1.getOn() + " : " + rb2.getOn());
        Mouse.click(220, 340);
        System.out.println(rb0.getOn() + " : " + rb1.getOn() + " : " + rb2.getOn());
        Mouse.click(10, 10);
        System.out.println(rb0.getOn() + " : " + rb1.getOn() + " : " + rb2.getOn());
        Mouse.click(65, 70);
        System.out.println(rb0.getOn() + " : " + rb1.getOn() + " : " + rb2.getOn());
        Mouse.click(115, 98);
        System.out.println(rb0.getOn() + " : " + rb1.getOn() + " : " + rb2.getOn());
    }
}
