package net.Junior.spring.app04_full_spring_dependency_injection_on_xml.entity;

import net.Junior.spring.app04_full_spring_dependency_injection_on_xml.bean.BaseBean;

/**
 * Created by root on 07.05.2015.
 */
public class Foo {
    private BaseBean baseBean;

    public void showIntroduce() {
        baseBean.introduce();
    }

    public void setBaseBean(BaseBean baseBean) {
        //тут я сделал инъекцию через сеттер, можно было сделать в xml-е через конструктор
        this.baseBean = baseBean;
    }

    public void throwEx() {
        try {
            baseBean.throwRuntimeException();
        } catch (RuntimeException ex) {
            System.out.println("cached test runtime exception");
        }
    }
}
/*
Штука, которая использует интерфейс
 */