package net.mr_faton.Multithreading.Monitor.BlockingQueueTest;

/**
 * Created by Faton on 05.11.2014.
 */
public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (this.elem != null) {
            this.wait();
        }
        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (this.elem == null) {
            this.wait();
        }
        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
