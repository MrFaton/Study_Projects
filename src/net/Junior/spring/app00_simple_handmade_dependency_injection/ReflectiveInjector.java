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
    public Map<String, String> getBeanIdAndBeanClass(File configFile) {
        try {
            if (!configFile.exists()) {
                throw new FileNotFoundException("config file not found");
            }
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(configFile);

            Node beanElement = document.getElementsByTagName("bean").item(0);
            NamedNodeMap beanAttr = beanElement.getAttributes();

            String beanId = beanAttr.getNamedItem("id").getTextContent();
            String beanClassPath = beanAttr.getNamedItem("class").getTextContent();

            if (beanId == null || beanClassPath == null || beanId.length() == 0 || beanClassPath.length() == 0) {
                throw new IllegalArgumentException("beanId = " + beanId + "\nbeanClassPath = " + beanClassPath);
            }

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

    public List<Field> annotatedFields(Class clazz) {
        List<Field> fieldList = new LinkedList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                fieldList.add(field);
            }
        }
        return fieldList;
    }

    public void injectBean(Class classToInject, List<Field> annotatedFieldList, String beanClassPath) {
        for (Field field : annotatedFieldList) {
            field.setAccessible(true);
            Object bean = createObject(beanClassPath);
            try {
                field.set(classToInject, bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    private Object createObject(String classPath) {
        try {
            Class<?> clazz = Class.forName(classPath);
            Constructor<?> constructor = clazz.getConstructor();
            Object bean = constructor.newInstance();
            return bean;
        } catch (Exception e) {
            System.err.println("Error during building object from class path");
            e.printStackTrace();
        }
        return null;
    }
}
