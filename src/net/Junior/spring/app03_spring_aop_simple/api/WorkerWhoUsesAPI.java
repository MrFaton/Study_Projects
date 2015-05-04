package net.Junior.spring.app03_spring_aop_simple.api;

import net.Junior.spring.app03_spring_aop_simple.annotation.Inject;
import net.Junior.spring.app03_spring_aop_simple.entity.DependencyInjector;

/**
 * Created by root on 03.05.2015.
 */
public class WorkerWhoUsesAPI extends DependencyInjector {
    @Inject("SomeAPI_Impl")
    private Some_API someAPI;

    public void useApi() {
        someAPI.sayHi();
        someAPI.saySomething("bla-bla-bla");
        someAPI.echo("uhaha", 3);
    }

}
