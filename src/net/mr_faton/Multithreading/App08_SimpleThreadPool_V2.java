package net.mr_faton.Multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by root on 28.02.2015.
 */
public class App08_SimpleThreadPool_V2 {
    private final ThreadGroup workerGroup = new ThreadGroup("MyWorkers");
    /*
    в принципе в очередь можно сделать чтобы добавлялся любой класс, но дело в том, что в калссе Runnable всегда можно
    вызвать метод run и там точно будет задача, которую нужно выполнить
     */
    private final BlockingQueue<Runnable> taskQueue;
    private int numOfThread = 1;

    public App08_SimpleThreadPool_V2(int threadCount, final BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
        for (int i = 0; i < threadCount; i++) {
            Thread worker = new Thread(workerGroup, new Worker());
            System.out.println("Поток №" + numOfThread + " создан и готов работать=================");
            worker.start();
            numOfThread++;
        }
    }

    public void submitIt(Runnable task) {
        taskQueue.add(task);
    }

    public void shutdown() {
        workerGroup.interrupt();
    }

    private class Worker implements Runnable {
        private int number = numOfThread;
        @Override
        public void run() {
            while (true) {
                try {
                    //вот здесь необязательно чтобы в очереди были Runnable-ы, тут мог бы быть любой класс
                    Runnable task = taskQueue.take();
                    System.out.println("Поток №" + number + " принялся за работу...");
                    task.run();
                    System.out.println("Поток №" + number + " завершил работу...");
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}

class Test_App08 {
    private static final BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(15);
    private static int x = 5;
    private static int y = 4;

    public static void main(String[] args) {
        //пулл создан и теперь мы можем кидать сюда любые задачи в виде наследника класса Runnable
        App08_SimpleThreadPool_V2 threadPool_v2 = new App08_SimpleThreadPool_V2(10, taskQueue);

        threadPool_v2.submitIt(new Runnable() {
            @Override
            public void run() {
                System.out.println(x + " + " + y + " = " + (x + y));
            }
        });

        threadPool_v2.submitIt(new Runnable() {
            @Override
            public void run() {
                System.out.println(x + " * " + y + " = " + (x * y));
            }
        });
    }
}
/*
Такое же приложение как и App07_SimpleThreadPool, только для меня чуть понятней, хотя вроде в предыдущем приложениии
решение с Callable вроде как лучше
 */