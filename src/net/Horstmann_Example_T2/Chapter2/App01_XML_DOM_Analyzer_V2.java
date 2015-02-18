package net.Horstmann_Example_T2.Chapter2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/**
 * Created by root on 12.02.2015.
 */
public class App01_XML_DOM_Analyzer_V2 {

    public static void main(String[] args) throws ParserConfigurationException {
        Document doc = null;
        File file = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\TestPage1In.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //активируем проверку xml документа на соответствие DTD определениям. Это позволяет подавлять все разделители
        factory.setValidating(true);
        //говорим построителю документов не учитывать разделители
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        //желательно установить свой обработчик исключейний, т.к. стандартный ничего не делает, только бросает исключ.
        builder.setErrorHandler(new MyErrorHandler());
        try {
            doc = builder.parse(file);
        } catch (SAXException e) {
            System.err.println("SAXException");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException");
            e.printStackTrace();
        }
        if (doc == null) System.exit(1);
        Element root = doc.getDocumentElement();
        //благодаря включенной проверке и включеннёх в файл DTD определений, в списке будут тольок элементы, а не разделители
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Карточка №" + (i + 1));
            printNod(nodeList.item(i), 1);
            System.out.println();
        }
    }

    public static void printNod(Node card, int spaces) {
        NodeList cardList = card.getChildNodes();
        for (int i = 0; i < cardList.getLength(); i++) {
            StringBuilder temp = new StringBuilder("");
            for (int x = 0; x <= spaces; x++) {
                temp.append(" ");
            }
            System.out.print(temp + cardList.item(i).getNodeName() + " = ");
            if (cardList.item(i).getChildNodes().getLength() == 1) {
                System.out.println(cardList.item(i).getTextContent().trim());
            } else {
                System.out.println();
                printNod(cardList.item(i), spaces + i);
            }
        }
    }
}

class MyErrorHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.err.println("Есть предупреждения..");
        exception.printStackTrace();
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.err.println("Произошла ошибка");
        exception.printStackTrace();
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("Критическая ошибка....");
        exception.printStackTrace();
    }
}

/*
Класс пытается вывести назввание элемента разметки = текст, который там храниться.
Как в xml-документе: <word>April</word>
Как выводит программа: word = April
 */