package net.Junior.spring.app01_spring_dependency_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;


/**
 * Created by root on 29.04.2015.
 */
public class DependencyInjector {
    private String appContextConfigPath;//путь к xml файлу с конфигурациями
    private ApplicationContext applicationContext;//вот это уже spring. Конструирует нам бин из путь к классу

    public DependencyInjector() {
        appContextConfigPath = "net\\Junior\\spring\\app01_spring_dependency_injection\\Config.xml";
        applicationContext = new ClassPathXmlApplicationContext(appContextConfigPath);
    }

    public void inject() {
        /*
        Что такое this? Дело в том, что injectDependency() является виртуальным методом для классов наследников из
        которых он вызываетя, т.к этот метод есть только у предка, у наследника его нет и наследник не может его
        переопределить т.к. метод финальный, значит объект наследник может вызвать этот метод только у объекта-предка.
        Это всё означает, что вызов метода injectDependency() происходит именно конкретным объектом-наследником -
        этим объектом является this, т.е. this - это тот объект из которого вызвали метод injectDependency().
        Таким образом мы можем получить доступ к потомку в методе предка.
         */
        //плучаем класс объектка-наследника, который взывал метод (т.е. класс объекта настледника, который вызал метод)
        //это будет у нас текущим классом
        Class<?> currentClass = this.getClass();
        /*
        Дело в том, что между нашим классом-предком (который производит инъекцию зависимости) и классом-потомком,
        который вызвал метод injectDependency() в иерархии могут стоять разные классы, которые тоже могут содержать поля,
        в которые необходимо провести инъекцию. Мы обязаны перебрать все класс по иерархии от потомка к предку для того
        чтобы инъекцировать зависимости во все поля. Более наглядный пример в app02_spring_dependency_injection_complex
         */
        //пока текущий класс не равен классу самого верхнего уровня
        while (currentClass != DependencyInjector.class) {
            //по рефлексии получаем список всех полей текущего класса
            Field[] fields = currentClass.getDeclaredFields();
            //перебираем каждое поле
            for (Field field : fields) {
                //ищем относящуюся к полю аннотацияю
                Inject foundAnnotation = field.getAnnotation(Inject.class);
                //если аннотация найдена
                if (foundAnnotation != null) {
                    /*
                    получаеv значени аннотации (Напр: "MyDemoBean"), значение аннотации соответсвтует конкретном
                    классу-бину в конфигурационном xml-е
                     */
                    String foundAnnotationValue = foundAnnotation.value();
                    //выполняем инъекцию, передаём конкретный объект, поле и имя бина для инъекции
                    doInjection(this, field, foundAnnotationValue);
                }
            }
            //подымаемся к следующему классу в иерархии от потомка к предку
            currentClass = currentClass.getSuperclass();
        }
    }

    //метод совершает инъекцю в поле
    private void doInjection(Object objectToInject, Field field, String foundAnnotationValue) {
        //spring помогает сконструировать нам объект бина по его имени (xml-е это id)
        Object bean = applicationContext.getBean(foundAnnotationValue);
        try {
            //делаем поле домтупным для записи (инъекции)
            field.setAccessible(true);
            //устанавливаем в поле наш сконстуированный спрингом бин
            field.set(objectToInject, bean);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            System.err.println("can't access to field");
            e.printStackTrace();
        }
    }
}
/*
Класс, который инъекцирует зависимости в бины, которые от него наследуются
*/