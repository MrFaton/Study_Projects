package net.mr_faton.Test;

/**
 * Created by Faton on 08.11.2014.
 */
public class Test {
    public static void main(String[] args) {
        int x = 79;
        System.out.println(x + " = " + Integer.toString(x, 2) + " в двоичной системе");
        System.out.println(x + " = " + Integer.toString(x, 8) + " в восьмеричной системе");
        System.out.println(x + " = " + Integer.toString(x, 16) + " в шестнадцатиричной системе");
    }
}

class test2 extends Test{
    int t = 5;
}
