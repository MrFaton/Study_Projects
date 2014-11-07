package net.mr_faton.Multithreading.Monitor.BlockingQueueTest;

/**
 * Created by Faton on 05.11.2014.
 */
public class ProducerConsumerExample_3x2 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1, 300, buffer)).start();
        new Thread(new Producer(100, 500, buffer)).start();
        new Thread(new Producer(1000, 700, buffer)).start();

        new Thread(new Consumer(buffer, 1)).start();
        new Thread(new Consumer(buffer, 2)).start();
    }
}
//Пример, где 3 производителя и 2 потребителя