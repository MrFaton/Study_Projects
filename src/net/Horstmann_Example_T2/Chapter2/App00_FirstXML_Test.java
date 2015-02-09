package net.Horstmann_Example_T2.Chapter2;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr_Faton on 09.02.2015.
 */
public class App00_FirstXML_Test {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //эти объекты нужны для того, чтобы получить экземпляр класса Document, который обрабатывает наш XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //получаем файл и на остновании DocumentBuilder и файла XML строим объект Document
        File file = new File("C:\\test.xml");
        Document doc = builder.parse(file);
        //из Document получаем объект Element - это корневой узел во всём XML документе (в него входят все остальные)
        Element root = doc.getDocumentElement();
        System.out.println(root + " = корневой элемент");
        System.out.println("****************************");
        //эти методы лучше запускать по отдельности. Их описание приведено ниже над каждым из методов
//        printAllChildren(root);
//        System.out.println("****************************");
//        printOnlyChildrenElements(root);
//        System.out.println("****************************");
//        printTextInChildren(root);
//        System.out.println("****************************");
        printTextInAllNods(root, 0);
    }

    //получает и печатает все дочерние элементы (узлы), входящие в состав корневого элемента XML
    public static void printAllChildren(Element root) {
        //список всех узлов, входящих в корневой узел
        NodeList children = root.getChildNodes();
        //длина этого списка
        System.out.println(children.getLength() + " = колличество детей");
        //пройтись по всему списку
        for (int i = 0; i < children.getLength(); i++) {
            //взять конкретный элемент (узел)
            System.out.println(" ребёнок под номером " + i + ": " + children.item(i));
        }
    }

    //получить и распечатать все подчиненные элементы (узлы), игнорируя все разделители
    public static void printOnlyChildrenElements(Element root) {
        //список всех узлов, входящих в корневой узел
        NodeList children = root.getChildNodes();
        //пройтись по всему списку
        for (int i = 0; i < children.getLength(); i++) {
            //присвоить ссылку типа Node на конкретный узел
            Node child = children.item(i);
            //проверить, относится наш узел к элементу или к разделителям
            if (child instanceof Element) {
                //елси относится к дочернему элементу, тогда привести тип к Element
                Element childElement = (Element) child;
                //распечатать этот узел (элемент), так как он не разделитель
                System.out.println(childElement + " ребёнок под номером " + i);
//                System.out.println(children.item(i) + " ребёнок под номером " + i);//можно получить дчерний узел и таким способом
            }
        }
    }

    //пытается напечатать текст, содержащийся в узлах (тэгах)
    public static void printTextInChildren(Element root) {
        //список всех узлов, входящих в корневой узел
        NodeList children = root.getChildNodes();
        //пройтись по всему списку
        for (int i = 0; i < children.getLength(); i++) {
            //присвоить ссылку типа Node на конкретный узел
            Node child = children.item(i);
            //проверить, относится наш узел к элементу или к разделителям
            if (child instanceof Element) {
                //елси относится к дочернему элементу, тогда привести тип к Element
                Element childElement = (Element) child;
                System.out.println(childElement + ", коллчиество дочерних элементов, входящих в этот узел: " + childElement.getChildNodes().getLength());
                //помогает нам получить текст узла
                Text textNode = (Text) childElement.getFirstChild();
                //обрезать значение (реальный текст) от всяких пробелов и табуляций
                String str = textNode.getData().trim();
                System.out.println(str);
            }
        }
    }

    /*
    печатает весь текст, который есть во всех узлах (элементах / тэгах). Метод рекурсивен. В качестве параметров
    получает узел (элемент), чтобы углубиться во все его дочерние элементы и прочитать у них текстовую информацию,
    а также получает коллчиство необходимых пробелов перед каждой строкой
     */
    public static void printTextInAllNods(Element root, int spaces) {
        //список всех узлов, входящих в переданый узел
        NodeList children = root.getChildNodes();
        //пройтись по всему списку
        for (int i = 0; i < children.getLength(); i++) {
            //присвоить ссылку типа Node на конкретный узел
            Node child = children.item(i);
            //проверить, относится наш узел к элементу или к разделителям
            if (child instanceof Element) {
                //елси относится к дочернему элементу, тогда привести тип к Element
                Element childElement = (Element) child;
                //строка temp нужна для того, чтобы сформировать необходимое кличество пробелов перед ощей строкой
                StringBuilder temp = new StringBuilder("");
                //формирует необходимое кол-во пробелов в temp
                for (int y = 0; y <= spaces; y++) {
                    temp.append(" ");
                }
                //выводит открывающееся имя узла (тега)
                System.out.println(temp + childElement.toString() + ">>");
                Text textNode = (Text) childElement.getFirstChild();
                //эта проверка необходима, так как textNode == null, если встерчает строку: <statistics status="2" />
                if (textNode != null) {
                    String str = temp + textNode.getData().trim();
                    /*
                если текущий узел не содержит в себе текста, а содержит в себе сразу другие узлы, то после него
                выводится пустая строка, поэтому создаём фильтр, который проверяет, если строка содержит одни
                пробелы, то она не выводится
                 */
                    if (!str.endsWith(" ")) {
                        System.out.println(str);
                    }
                }
                /*
                так как мы находились в узле, а не в разделителе, мы вызываем этот же метод и передаём ему себя
                (текущий элемент (узел), чтобы можно было просмотреть все дочерние узлы и все узлы-внуки
                которые есть в текущем узле. Всё это похоже на структуру папок в проводнике: одна папка содержит
                в себе другую папку, другая в себе третью и т.д.). Условием выхода из рекурсии является цикл. Рано или
                поздно мы доходим до самого нижнего узла, котороый не содержит в себе других узлов и это прекращает
                рекурсию.
                 */
                printTextInAllNods(childElement, spaces + i);
                //печатаем закрывающийся тэг и имя того узла, в котором мы находились
                System.out.println(temp + "<<" + childElement.toString());
            }

        }
    }
}
