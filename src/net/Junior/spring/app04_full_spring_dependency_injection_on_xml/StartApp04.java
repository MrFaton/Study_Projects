package net.Junior.spring.app04_full_spring_dependency_injection_on_xml;

import net.Junior.spring.app04_full_spring_dependency_injection_on_xml.entity.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by root on 07.05.2015.
 */
public class StartApp04 {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("net\\Junior\\spring\\app04_full_spring_dependency_injection_on_xml\\Config.xml");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Foo foo = (Foo) applicationContext.getBean("Foo");
                foo.showIntroduce();
            }
        }).start();
        Foo foo = (Foo) applicationContext.getBean("Foo");
        foo.showIntroduce();
        foo.throwEx();
    }
}
