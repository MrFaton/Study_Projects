package net.mr_faton.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Mr_Faton on 23.06.2015.
 */
public class Test2 {

    public static void main(String[] args) {
        String str = "123.456";
        int pointPos = str.indexOf(".");
        int num1 = Integer.valueOf(str.substring(0, pointPos));
        int num2 = Integer.valueOf(str.substring(pointPos + 1, str.length()));
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }
}
