package net.mr_faton.Different_Things;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.RandomAccess;

/**
 * Created by Faton on 07.10.2014.
 */
public class InstanceofSupported {
    public static void main(String[] args) {
        System.out.println("Поддерживает ли ArrayList интерфейс RandomAccess?");
        ArrayList list = new ArrayList();
        System.out.println(list instanceof RandomAccess);

        System.out.println("Поддерживает ли LinkedList интерфейс RandomAccess?");
        LinkedList linList = new LinkedList();
        System.out.println(linList instanceof RandomAccess);
    }

}
