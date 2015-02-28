//package net.mr_faton.Multithreading;
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.Callable;
//
///**
// * Created by root on 28.02.2015.
// */
//public class App07_SimpleThreadPool {
//    //создаём блокирующую очередь типа Callable
//    private final BlockingQueue<Callable> taskList;
//    //создаём группу потоков
//    private final ThreadGroup group = new ThreadGroup("MyOwnWorkers");
//    //номер потока
//    private int num = 1;
//
//    public App07_SimpleThreadPool(int threadCount, final BlockingQueue<Callable> taskQueue) {
//        //получаем из конструктора блокирующую очередь
//        this.taskList = taskQueue;
//        //создаём запрошенное в конструкторе общее колличество потоков
//        for (int i = 0; i < threadCount; i++) {
//            //создаём поток и добавляем его в группу
//            Thread worker = new Thread(group, new Worker());
//            System.out.println("***** Поток " + num++ + " создан и запущен");
//            //стартуем поток
//            worker.start();
//        }
//    }
//    //метод, который добавляет задачу в очередь
//    public <T> void submitIt(Callable<T> task) throws InterruptedException {
//        taskList.put(task);
//    }
//    //завершает все потоки
//    public void shutdown() {
//        group.interrupt();
//    }
//    /*
//    класс, который описывает выполнение работы каждого потока. Поток берёт задачу из очереди и вызывает метод call(),
//    выполняя его внутренности. Класс реализован при помощи интерфейса Runnable
//     */
//    private class Worker implements Runnable {
//        private int threadNum = num;
//        @Override
//        public void run() {
//            while (true) {
//                try {
//                    System.out.println("Поток " + threadNum + " берёт задачу из очереди---------");
//                    //берём задачу из списка
//                    Callable task = taskList.take();
//                    //запускаем задачу на выполение
//                    task.call();
//                    System.out.println("Поток " + threadNum + " выполнил задачу----------------");
//                } catch (Exception ex) {
//                    //когда у группы потоков вызвали метод interrupt - нужно прервать цикл, тем самым завершив поток
//                    break;
//                }
//            }
//        }
//    }
//}
////тестовый класс
//class Test_App07 {
//    /*
//    создаём блокирующую очередь с ограничением в 200 ячеек. Это нужно для того, чтобы если задачи поступают в очередь
//    быстрее чем они выполняются, чтобы потоки которые ложат задачи в очередь могли приостанавливаться. Елсли этого
//    не сделать, то можно вылететь по OutOfMemoryException
//     */
//    private static final BlockingQueue<Callable> taskQueue = new ArrayBlockingQueue<>(200);
//
//    public static void main(String[] args) throws Exception {
//        int x = 4;
//        int y = 8;
//        //создаём экземпляр пула потоков
//        App07_SimpleThreadPool pool = new App07_SimpleThreadPool(8, taskQueue);
//        //добавляем задачу в пулл
//        //ВНИМАНИЕ! Тут Void - это не тип возвращаемого значения, а класс! От символизирует то, что ничего не должно возворащаться
//        pool.submitIt(new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                System.out.println("задача сложить 2 числа х + у:");
//                System.out.println(x + y + "<--------------------");
//                return null;
//            }
//        });
//        //добавляем задачу в пулл
//        pool.submitIt(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return x + y;
//            }
//        });
//        //закрыть все потоки
//        pool.shutdown();
//    }
//}
///*
//Весь этот пример демонстрирует ручное создание пулла потоков, которые выполняют любые задачи
// */