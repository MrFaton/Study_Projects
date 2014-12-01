package net.mr_faton.OOP.App14_Anonymous_classes.App00_Pac;

/**
 * Created by Faton on 30.11.2014.
 */
public class App00 {
    int k = 0;

    public void f() {
        int p = 1;
        System.out.println(p);

        Runnable ref = new Runnable() {
            @Override
            public void run() {
                k = 8;
                System.out.println(k);
//                p = 5;//не компилируется, так как р - это локальная переменная, а с локальными переменными нельзя работать из анонимных классов
//                System.out.println(p);//таже причина что и выше
            }
        };
    }
}
