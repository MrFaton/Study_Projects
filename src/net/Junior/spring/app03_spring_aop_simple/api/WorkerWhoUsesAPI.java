package net.Junior.spring.app03_spring_aop_simple.api;

import net.Junior.spring.app03_spring_aop_simple.annotation.Inject;
import net.Junior.spring.app03_spring_aop_simple.entity.DependencyInjector;
import net.Junior.spring.app03_spring_aop_simple.entity.TimeTalk;

/**
 * Created by root on 03.05.2015.
 */
public class WorkerWhoUsesAPI extends DependencyInjector {
    @Inject("SomeAPI_Impl")
    private Some_API someAPI;//сюда инъекцируем конкретную реализацию
    private TimeTalk timeTalk;//инициируем вручную (чтобы показать, что наш логгер работает только с бинами спринга)

    public WorkerWhoUsesAPI() {
        //инициализируем переменную
        timeTalk = new TimeTalk();
    }

    public void useApi() {
        //используем методы из нашего интерфейса
        someAPI.sayHi();
        someAPI.saySomething("bla-bla-bla");
        someAPI.echo("uhaha", 3);

        //спользуем метод из нашего вручную инициализированного объекта
        timeTalk.sayTime();
    }

}
/*
Класс, который использует интерфейс
 */