package net.mr_faton.Test;
import java.util.*;

/**
 * Created by Faton on 08.11.2014.
 */

public class Test {
    public static void main(String[] args) {
        Currency currency = Currency.getInstance(Locale.getDefault());
        System.out.println(currency.getNumericCode());
    }
}