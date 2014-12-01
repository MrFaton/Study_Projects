package net.mr_faton.OOP.App14_Anonymous_classes.App02_pac;

/**
 * Created by Faton on 30.11.2014.
 */
public class App02 {
    int k = 0;

    public void f() {
        final int[] p = {1};
        System.out.println(p);

        Runnable ref = new Runnable() {
            @Override
            public void run() {
                k = 8;
                System.out.println(k);
                p[0] = 5;//теперь мы пожем и читать и писать р
                System.out.println(p[0]);
            }
        };
    }
}
