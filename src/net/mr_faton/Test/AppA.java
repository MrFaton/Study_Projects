package net.mr_faton.Test;

/**
 * Created by Mr_Faton on 29.05.2015.
 */
public class AppA implements App {
    @Override
    public void sayA() {
        System.out.println(getClass().getSimpleName() + " says: A");
    }

    @Override
    public void sayB() {
        System.out.println(getClass().getSimpleName() + " says: B");
    }
}
