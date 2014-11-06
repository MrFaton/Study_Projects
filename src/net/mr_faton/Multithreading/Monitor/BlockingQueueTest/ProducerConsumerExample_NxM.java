package net.mr_faton.Multithreading.Monitor.BlockingQueueTest;

/**
 * Created by Faton on 05.11.2014.
 */
public class ProducerConsumerExample_NxM {
    public static void main(String[] args) {
        SingleElementBuffer bufferA = new SingleElementBuffer();
        SingleElementBuffer bufferB = new SingleElementBuffer();

        new Thread(new Producer(1, 1000, bufferA)).start();

        new Thread(new Consumer(bufferA, 1)).start();
        new Thread(new Consumer(bufferA, 2)).start();
        //******************************************

        new Thread(new Producer(100, 500, bufferB)).start();
        new Thread(new Producer(1000, 450, bufferB)).start();
        new Thread(new Consumer(bufferB, 3)).start();

    }
}
//Пример, с двумя очередями