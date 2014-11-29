package net.mr_faton.OOP.App13_Inner_classes.App02_Pac;

/**
 * Created by Faton on 29.11.2014.
 */
public class App02 {
    public int k;

    public App02(int k) {
        this.k = k;
    }

    public class Inner {
        public void f() {
            System.out.println(k++);
        }
    }
}

class Test {
    public static void main(String[] args) {
        App02 app = new App02(10);
        App02.Inner inner0 = app.new Inner();
        App02.Inner inner1 = app.new Inner();

        inner0.f();
        inner1.f();
        inner0.f();
        inner1.f();
    }
}