package net.mr_faton.Multithreading;

/**
 * Created by root on 06.11.2014.
 */
public class App05 {
    public static void main(String[] args) {
        for (int k = 0; k < 5; k++) {
            final int tmp = k;//нужно уточнить вопрос: "Почему если мы из анононимного класса используем локальные переменные они должны быть финальными?"
            new Thread(new Runnable() {
                public void run() {
                    hello(tmp);
                }
            }).start();
        }
    }

    public synchronized static void hello(int id) {
        System.out.println("Поток с номером " + id + " вошёл в синхронизированный метод");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignore) {/*NOP*/}
    }
}
/*Демонстирует что blocked-set это таки множество в котором действиетльно нет почереди и порядка. К synchronized методу
hello все потоки приходят в порядке очереди 0, 1, 2, 3, 4 но проходят этот метод они явно не по очереди. JVM посте того
как один поток освободил synchronized метод, случайным образом выбирает следующий поток для работы, который находится в
blocked-set.
 */