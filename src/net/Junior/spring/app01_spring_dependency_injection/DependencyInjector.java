package net.Junior.spring.app01_spring_dependency_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;


/**
 * Created by root on 29.04.2015.
 */
public class DependencyInjector {
    private String appContextConfigPath;
    private ApplicationContext applicationContext;

    public DependencyInjector() {
        appContextConfigPath = "net\\Junior\\spring\\app01_spring_dependency_injection\\Config.xml";
        applicationContext = new ClassPathXmlApplicationContext(appContextConfigPath);
    }

    public void inject() {
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
        Object bean = applicationContext.getBean(foundAnnotationValue);
        try {
            field.setAccessible(true);
            field.set(objectToInject, bean);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            System.err.println("can't access to field");
            e.printStackTrace();
        }
    }
}
