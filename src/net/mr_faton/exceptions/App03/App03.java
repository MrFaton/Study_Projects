package net.mr_faton.exceptions.App03;

/**
 * Created by root on 26.08.2014.
 */
public class App03 {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            f();
            System.err.println();
        }
    }

    private static void f() {
        for (int k = 0; k < 2; k++) {
            System.err.print(0);
//            if (true) continue; // Continue говорит о том, что цикл продолжает выполняться, но всё, что после continue не выполняется.
//            if (true) break; // break прекращает цикл
//            if (true) return; // return вообще прекращает метод
            if (true) throw new Error(); // Тут throw ломает и основной метод мейн, из которого был вызван f
            System.err.print(1);
        }
        System.err.print(2);
    }
}
