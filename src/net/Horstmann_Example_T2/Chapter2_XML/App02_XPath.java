package net.Horstmann_Example_T2.Chapter2_XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Created by root on 16.02.2015.
 */
public class App02_XPath {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        File file = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2_XML\\Files\\TestPage1In.xml");
        //эти объекты нужны для того, чтобы получить экземпляр класса Document, который обрабатывает наш XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        //Нужен экземпляр типа XPath для обработки путей к элементам разметки
        XPathFactory xpfactory = XPathFactory.newInstance();
        XPath path = xpfactory.newXPath();
        //подсчитать общее колличество элементов card в корневом элементе cards
        System.out.println("Всего карточек: " + path.evaluate("count (/cards/card)", doc));
        /*
        отобразить текст, который находится: (корневой элемент cards)/(элемент card №2)/(текст элемента word). Если
        элементов несколько, то его номер указывается в квадратных скобках
         */
        String text = path.evaluate("/cards/card[2]/word", doc);
        System.out.println("\nАнглийское слово второй карточки: " + text);

        text = path.evaluate("/cards/card[3]/meanings/translations/word[2]", doc);
        System.out.println("\nВторой слово превода из третьей карточки: " + text);
        System.out.println("\nкакие словам там вообще существуют: ");
        NodeList nodes = (NodeList) path.evaluate("/cards/card[3]/meanings/translations/word", doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getTextContent());
        }

        System.out.println("\nПрочитать атрибут name у элемента sound в третьей карте");
        String str = path.evaluate("/cards/card[3]/meanings/sound/@name", doc);
        System.out.println("name in sound = " + str);
    }
}
/*
Класс пытается выдать текст, который находится внутри разметки по указанному пути.
Например путь: /cards/card[2]/word, означает: зайти внутрь корневой карты (cards), далее зайти в карту №2 (card[2]) и
прочитать там текст, который находится внутри разметки word
 */