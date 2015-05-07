package net.Junior.spring.app04_full_spring_dependency_injection_on_xml.bean.impl;

import net.Junior.spring.app04_full_spring_dependency_injection_on_xml.bean.BaseBean;

/**
 * Created by root on 07.05.2015.
 */
public class DefaultBaseBean implements BaseBean {

    @Override
    public void introduce() {
        System.out.println("I am DefaultBaseBean");
    }

    @Override
    public void throwRuntimeException() throws RuntimeException {
        throw new RuntimeException("test exception");
    }
}
/*
Дефолтная реализиция интерфейса
 */