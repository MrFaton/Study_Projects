package net.mr_faton.OOP.App14_Anonymous_classes.App01_Pac;

/**
 * Created by Faton on 30.11.2014.
 */
public class App01 {
    int k = 0;

    public void f() {
        final int p = 1;
        System.out.println(p);

        Runnable ref = new Runnable() {
            @Override
            public void run() {
                k = 8;
                System.out.println(k);
//                p = 5;//не компилируется, так как р - это финальная переменная, а финальные переменные не меняются
                System.out.println(p);
            }
        };
    }
}
