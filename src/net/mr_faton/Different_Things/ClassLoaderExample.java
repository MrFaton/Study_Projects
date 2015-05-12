package net.mr_faton.Different_Things;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by Mr_Faton on 12.05.2015.
 */
public class ClassLoaderExample {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = ClassLoaderExample.class.getClassLoader();
        Enumeration<URL> drivers = loader.getResources("META-INF/services/java.sql.Driver");
        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement());
        }
    }
}
