package net.Junior.spring.app00_simple_handmade_dependency_injection;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 25.04.2015.
 */
public class App00_Start {
    //не инициализированное поле интфейса, методы которого мы будем использовать, помеченное аннотацией
    @Inject("MyDemoBean")
    private static DemoBean demoBean;

    public static void main(String[] args) {
        //инъекцирует зависимоесть (т.е. инициализирует поле помеченное аннотацией бином из Config.xml)
        injectField();

        //дёргаем разные методы из интерфейса DemoBean
        demoBean.saySomething();
        demoBean.printX();
        demoBean.printY();
    }

    private static void injectField() {
        //определяем путь к файлу с настройками Config.xml
        File configFile = new File(System.getProperty("user.dir") + "\\" + "src\\net\\Junior\\spring\\" +
                "app00_simple_handmade_dependency_injection\\Config.xml");
        //имя бина (должно соответсвовать названию аннотации MyDemoBean)
        String beanId;
        /*
        полное имя класса бина (можно сказать это путь к бину
        (net.Junior.spring.app00_simple_handmade_dependency_injection.DemoBeanA))
         */
        String beanClassPath;

        //создаём экземпляр рефлексивного инъектора, который и инициализирует наше поле demoBean
        ReflectiveInjector reflectiveInjector = new ReflectiveInjector();
        //передаём ему файл конфигурации и получаем карту с именем аннотации и соответвствующему ей бину
        Map<String, String> parameters = reflectiveInjector.getBeanIdAndBeanClass(configFile);
        beanId = parameters.get("id");
        beanClassPath = parameters.get("class");

        //получаем список всех полей, которые аннотированы аннотацией @Inject в нашем классе (передаём ему объект класса)
        List<Field> annotatedFieldsList = reflectiveInjector.annotatedFields(App00_Start.class);

        /*
        выполняем инъекцию в наш класс, передаём в метод класс, поля отмеченные аннотацией, бин которым нужно
        инициализировать поле
         */
        reflectiveInjector.injectBean(App00_Start.class, annotatedFieldsList, beanClassPath);
    }
}
/*
Везде мы используем переменную demoBean, но во первых это интрфейс, а во вторых эта переменная нигде не инициализирована.
Мы на неё вешаем аннотацию @Inject("MyDemoBean"). Далее при запуске программы класс ReflectiveInjector рефлексивно
перебирает все поля класса App00_Start и инъекцирует (инициализирует) поля помеченные аннотацией @Inject("MyDemoBean")
бином, который указан в файле Config.xml под именем бина "MyDemoBean" это класс либо "DemoBeanA" или "DemoBeanВ".
Но вообще это не очень корректный пример инъекции, потому что мы как бы внутри класса которому нажна инъекция вызываем
внешний класс инъектор. Например если мы бы работали с Tomcat-ом и нам бы нужны были инъекции в контроллерах, то
правильно было бы запускать объект-инъектор в, например, классе ServletContextListener - методе contextInitialized,
который дёргается единажды при старте Tomcat-а.

Конкретная реализаци интерфейса DemoBean, находится в файле конфигураций.
 */