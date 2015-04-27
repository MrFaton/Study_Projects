package net.Junior.spring.app00_simple_handmade_dependency_injection;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 25.04.2015.
 */
public class ReflectiveInjector {
    //получает из xml-файла имя (ид) бина и соответствующий ему класс бина
    public Map<String, String> getBeanIdAndBeanClass(File configFile) {
        try {
            //если файл с конфигурацией не существует
            if (!configFile.exists()) {
                throw new FileNotFoundException("config file not found");
            }
            //строим докумен из файла с конфигурациями
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(configFile);

            //вытаскиваем из документа узел "bean"
            Node beanElement = document.getElementsByTagName("bean").item(0);
            //вытаскиваем из узла все аттрибуты
            NamedNodeMap beanAttr = beanElement.getAttributes();

            //получаем значение аттрибутов ид и класс
            String beanId = beanAttr.getNamedItem("id").getTextContent();
            String beanClassPath = beanAttr.getNamedItem("class").getTextContent();

            //если какой-то из значений аттрибутов не существует либо пуст
            if (beanId == null || beanClassPath == null || beanId.length() == 0 || beanClassPath.length() == 0) {
                throw new IllegalArgumentException("beanId = " + beanId + "\nbeanClassPath = " + beanClassPath);
            }

            //пакуем в мапу значение аттрибутов, затем возвращаем эту мапу
            Map<String, String> parameters = new LinkedHashMap<>();
            parameters.put("id", beanId);
            parameters.put("class", beanClassPath);
            return parameters;
        } catch (ParserConfigurationException | SAXException | IOException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    //получить рефлексивным путём список всех полей, которые есть в переданном классе
    public List<Field> annotatedFields(Class clazz) {
        //создаём список хранящий объекты типа Field
        List<Field> fieldList = new LinkedList<>();
        //получить массив всех полей переданнго класса
        Field[] fields = clazz.getDeclaredFields();
        //проанализировать каждое поле и определить наличие аннотации, если аннотировано, то добавить в список
        for (Field field : fields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                fieldList.add(field);
            }
        }
        //веруть список всех аннотированных полей
        return fieldList;
    }

    //произвести инъекцию зависимости в переданный класс
    public void injectBean(Class classToInject, List<Field> annotatedFieldList, String beanClassPath) {
        //произвести действия над каждым полем (все поля должны быть аннотированными)
        for (Field field : annotatedFieldList) {
            //сделать поле изменяемым (чтобы можно было его инициализировать)
            field.setAccessible(true);
            //получаем готовый, уже созданный объект бина
            Object bean = createObject(beanClassPath);
            try {
                //устанавливаем объект бина в поле
                field.set(classToInject, bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    /*
    создаёт объект бина, т.е. получает имя класса и создаёт его объект, т.е.
    получает net.Junior.spring.app00_simple_handmade_dependency_injection.DemoBeanA,
    делает как бы new net.Junior.spring.app00_simple_handmade_dependency_injection.DemoBeanA
    и возвращает экзепляр класса net.Junior.spring.app00_simple_handmade_dependency_injection.DemoBeanA
     */
    private Object createObject(String classPath) {
        try {
            //плучить класс по полному ииени класса
            Class<?> clazz = Class.forName(classPath);
            //создаём объект конструктора полученного класса
            Constructor<?> constructor = clazz.getConstructor();
            //запускам конструктор данного класса и получаем экзеспляр данного класса
            Object bean = constructor.newInstance();
            //возвращаем экземпляр данного класса
            return bean;
        } catch (Exception e) {
            System.err.println("Error during building object from class path");
            e.printStackTrace();
        }
        return null;
    }
}
/*
Класс, который выполняет инъекцию зависимости.
 */