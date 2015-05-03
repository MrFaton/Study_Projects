package net.Junior.spring.app02_spring_dependency_injection_complex.bean;

import net.Junior.spring.app02_spring_dependency_injection_complex.annotation.Inject;
import net.Junior.spring.app02_spring_dependency_injection_complex.entity.DependencyInjector;

/**
 * Created by root on 30.04.2015.
 */
public class Master_Bean extends DependencyInjector {
    //помечам аннотацией поле, в которое необходимо провести инъекцию
    @Inject("WorkerBeanTypeB")
    private Worker_Bean worker_bean;

    //метод, который вызывает все методы у конкретной реализации интрфейса Worker_Bean
    public void printWorkerBean_FromMasterBean() {
        worker_bean.doSomething();
        worker_bean.printNumber();
        worker_bean.printArrNumbers();
        worker_bean.printMap();
        worker_bean.printCoordinates();
    }
}
/*
Класс от которого наследуется другой бин: Slave_Bean.
Этот класс наследуется от класса DependencyInjector для того, чтобы в нём был метод injectDependency(), который
инъекцирует зависимости, помеченные аннотациями
 */