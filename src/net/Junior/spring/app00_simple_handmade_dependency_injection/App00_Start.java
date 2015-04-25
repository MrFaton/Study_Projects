package net.Junior.spring.app00_simple_handmade_dependency_injection;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 25.04.2015.
 */
public class App00_Start {
    @Inject("MyDemoBean")
    private static DemoBean demoBean;

    public static void main(String[] args) {
        injectField();

        demoBean.saySomething();
        demoBean.printX();
        demoBean.printY();
    }

    private static void injectField() {
        File configFile = new File(System.getProperty("user.dir") + "\\" + "src\\net\\Junior\\spring\\" +
                "app00_simple_handmade_dependency_injection\\Config.xml");
        String beanId;
        String beanClassPath;

        ReflectiveInjector reflectiveInjector = new ReflectiveInjector();
        Map<String, String> parameters = reflectiveInjector.getBeanIdAndBeanClass(configFile);
        beanId = parameters.get("id");
        beanClassPath = parameters.get("class");

        List<Field> annotatedFieldsList = reflectiveInjector.annotatedFields(App00_Start.class);

        reflectiveInjector.injectBean(App00_Start.class, annotatedFieldsList, beanClassPath);
    }
}
