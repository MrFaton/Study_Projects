package net.mr_faton.Multithreading.Monitor.BlockingQueueTest;

/**
 * Created by Faton on 05.11.2014.
 */
public class ProducerConsumerExample_1x1 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1, 1000, buffer)).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //nothing
        }
        new Thread(new Consumer(buffer, 1)).start();
    }
}
/*Пример, когда в начале производитель заполняет буффер, а потрпебителя ещё нет, потрибитель приходит через 5 секунд,
поэтому производитель заморижвается в методе put на пока не прийдёт потребитьель и неначёт забирать элементы из буффера,
т.е. опустошать его. Как только приходит потребитель, вся задержка только за производителем, т.к. он призводит новое
число через каждую секунду, а потребитель моментально забирает элемент. Теперь как только производитель произвёл элемент
потребитель сразу же забрал его из буффера.
 */