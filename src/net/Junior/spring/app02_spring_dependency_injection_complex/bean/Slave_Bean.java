package net.Junior.spring.app02_spring_dependency_injection_complex.bean;

import net.Junior.spring.app02_spring_dependency_injection_complex.annotation.Inject;

/**
 * Created by root on 30.04.2015.
 */
public class Slave_Bean extends Master_Bean {
    @Inject("WorkerBeanTypeA1")
    private Worker_Bean worker_bean_typeA1;
    @Inject("WorkerBeanTypeA2")
    private Worker_Bean worker_bean_typeA2;

    //метод, который вызывает все методы у конкретной реализации интрфейса Worker_Bean
    public void printWorkerBean_FromSlaveBean_BeanTypeA1() {
        worker_bean_typeA1.doSomething();
        worker_bean_typeA1.printNumber();
        worker_bean_typeA1.printArrNumbers();
        worker_bean_typeA1.printMap();
        worker_bean_typeA1.printCoordinates();
    }

    //метод, который вызывает все методы у конкретной реализации интрфейса Worker_Bean
    public void printWorkerBean_FromSlaveBean_BeanTypeA2() {
        worker_bean_typeA2.doSomething();
        worker_bean_typeA2.printNumber();
        worker_bean_typeA2.printArrNumbers();
        worker_bean_typeA2.printMap();
        worker_bean_typeA2.printCoordinates();
    }

    //у класса предка тоже есть поле с инъекцие, этот методе печатает поля объекта, которого инъекцируют у класса предка
    public void printMasterBean() {
        printWorkerBean_FromMasterBean();
    }
}
/*
Этот класс имеет 2 поля в которые инъекцируются разные экземпляры одного класса-бина
 */