package net.mr_faton.exceptions.App04;

/**
 * Created by root on 26.08.2014.
 */
public class App04 {
    public static void main(String[] args) {
        System.err.println("f:before");

        try {
            f();
        } catch (RuntimeException e) {// Остановили разрушене стека блоком catch в методе main, поэтому выполнение f продолжилось
            System.out.println("something wrong");
        }

//        f(); // нет catch, поэтому исключение летит до конца и ломает весь стек
        System.err.println("f:after");
    }

    private static void f() {
        System.err.println("g:before");
        g();
        System.err.println("g:after");
    }

    private static void g() {
//        return;
        throw new RuntimeException(); //Исключение ломает метод g, затем метод f и потом метод main, т.е. после поломки мы не возвращаемся назад по стеку, он сломан.
    }
}
