package net.Junior.spring.app01_spring_dependency_injection;

/**
 * Created by root on 29.04.2015.
 */
public class MainDemoBean extends DependencyInjector {
    @Inject("MyDemoBean")
    private DemoBean demoBean;

    public void begin() {
        demoBean.printX();
        demoBean.printY();
        demoBean.saySomething();
    }
}
/*
Класс, который использует интерфейс, в который будет инъекцироваться зависимость
 */