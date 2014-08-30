package net.mr_faton.exceptions.TestApp05;

/**
 * Created by root on 30.08.2014.
 */
public class TestApp05 {
    public static void main(String[] args) {
        System.err.println("f-before");
        try{
            f();
        } catch (Exception ex){
            System.err.println("f-catch");
        }
        System.err.println("f-after");
    }

    private static void f() {
        System.err.println("g-befor");
        g();
        System.err.println("g-after");
    }

    private static void g() {
        throw new RuntimeException();
    }
}
