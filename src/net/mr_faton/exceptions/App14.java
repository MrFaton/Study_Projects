package net.mr_faton.exceptions;

import java.io.IOException;

/**
 * Created by root on 11.09.2014.
 */
public class App14 {
    public static void main(String[] args) throws IOException {
        try (App14_Ok x = new App14_Ok("xxx"); App14_Ok y = new App14_Ok("yyy")) {
            System.err.println("body");
//            throw new Error();  //даже если выкинуть Error, то все равно у класса App14_Ok вызовется метод close();
        }
    }
}
// *В теле try после "try (App14_Ok x = new App14_Ok("xxx"))", переменной "х" уже нелься ничего присваивать, x=null - не
//прокатит, "х" как будто финальный, как будто try (final App14_Ok x = new App14_Ok("xxx"))
//* "x" будет виден только внутри фигурных скобок try