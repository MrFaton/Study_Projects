package net.Junior.spring.app01_spring_dependency_injection;

/**
 * Created by root on 29.04.2015.
 */
public class MainDemoBean extends DependencyInjector {
    @Inject("MyDemoBean")
    private DemoBean demoBean = new DemoBeanImplA();

    public void begin() {
        demoBean.printX();
        demoBean.printY();
        demoBean.saySomething();
    }
}
