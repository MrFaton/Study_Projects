package net.Junior.spring.app02_spring_dependency_injection_complex.entity;


import net.Junior.spring.app02_spring_dependency_injection_complex.annotation.Inject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;

/**
 * Created by root on 30.04.2015.
 */
public class DependencyInjector {
    private String appContextConfigPath;
    private ApplicationContext applicationContext;

    public DependencyInjector() {
        appContextConfigPath = "net\\Junior\\spring\\app02_spring_dependency_injection_complex\\Config.xml";
        applicationContext = new ClassPathXmlApplicationContext(appContextConfigPath);
    }

    public void injectDependency() {
        Class<?> currentClass = this.getClass();
        while (currentClass != DependencyInjector.class) {
            Field[] fields = currentClass.getDeclaredFields();
            for (Field field : fields) {
                Inject foundAnnotation = field.getAnnotation(Inject.class);
                if (foundAnnotation != null) {
                    String foundAnnotationValue = foundAnnotation.value();
                    doInjection(this, field, foundAnnotationValue);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }

    private void doInjection(Object objectToInject, Field field, String foundAnnotationValue) {
        try {
            Object bean = applicationContext.getBean(foundAnnotationValue);
            field.setAccessible(true);
            field.set(objectToInject, bean);
        } catch (BeansException ex) {
            System.err.println("No such bean or another bean exception");
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            System.err.println("can't access to field");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            System.err.println("bad argument");
            ex.printStackTrace();
        }
    }
}
