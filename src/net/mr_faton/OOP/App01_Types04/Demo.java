package net.mr_faton.OOP.App01_Types04;

/**
 * Created by root on 16.11.2014.
 */
public class Demo {
    public static void main(String[] args) {
        fun(new Integer(50));
        fun(new Double(1.8));
//        fun("Hello1");//-при запуске этой строки будет ClassCastException
    }

    public static void fun(Object ref) {
//        Number num = ref; - не компелируется, потому что это неявное приведение типа ВНИЗ! Такого в JAVA нет
        Number num = (Number) ref;/* так работает благодаря "(Number)", этим мы как бы уверяем компилятор в том,
                                     что ссылка типа ref указывает на объект типа Number и преобразование типа вниз
                                     провести можно. Но если мы в наш метод предадим другой обхект, например строку
                                     или массив интов, то мы схватим ClassCastException*/
        System.out.println(num.intValue());
    }
}
