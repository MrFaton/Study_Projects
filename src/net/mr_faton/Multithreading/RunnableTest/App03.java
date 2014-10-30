package net.mr_faton.Multithreading.RunnableTest;

/**
 * Created by Faton on 30.10.2014.
 */
public class App03 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Runnable r = new Runnable() {
                public void run() {
                    System.out.print("run() ");
                }
            };

            r.run();
            System.out.println("имя этого анонимного класса: " + r.getClass().getName());
        }
    }
}
/* тут компилятор догадался, что 10 раз используется один и тот же анонимный класс и поэтому он создал всего 1
экземпляр этого анонимного класса
 */