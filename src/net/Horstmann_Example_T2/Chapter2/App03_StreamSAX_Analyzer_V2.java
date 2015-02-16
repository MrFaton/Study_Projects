package net.Horstmann_Example_T2.Chapter2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.URL;

/**
 * Created by root on 16.02.2015.
 */
public class App03_StreamSAX_Analyzer_V2 {
    public static int count = -1;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\TestPage1In.xml");


        DefaultHandler myHandler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println(spaces() + "Начало документа XML >>");
                count++;
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                //имя элемента, открывающийся дескриптор (например: <word>)
                System.out.println(spaces() + localName + ">>");
                //распечать все атрибуты и их значения, если есть
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println(spaces() + "Атрибут: " + attributes.getLocalName(i) + "=" + attributes.getValue(i));
                }
                count++;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                //тест внутри элемента
                String str = new String(ch, start, length).trim();
                System.out.println(spaces() + str);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                count--;
                //имя элемента, закрывающийся дескриптор (например: </word>)
                System.out.println(spaces() + "<<" + localName);
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("<< Конец документа XML");
            }
        };

        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        //включает пространство имён
        saxFactory.setNamespaceAware(true);
        SAXParser saxParser = saxFactory.newSAXParser();
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        saxParser.parse(in, myHandler);
    }

    public static String spaces() {
        String str = "";
        for (int i = 0; i <= count; i++) {
            str += " ";
        }
        return str;
    }
}
/*
Пример потокового SAX-анализатора. Принцип его действия: на каждое событие, он вызывает определённый метод из данного
обработчика событий. Имеется стандартный обработчик событий DefaultHandler, все его методы просто ничего не делают.
Поэтому, если мы хотим реакций анализатора на определённые события (печать имени элемента, текста элемента), нам
необходимо переопределить необходимые нам методы. Например, часто переопределяемые методы:
++ startDocument() - этот метод запускается при начале XML-документа
++ endDocument() - этот в конце документа
++ startElement() - этот в начале элемента
++ endElement() - этот в конце элемента
++ characters() - тут находится текст элемента, а именно в массиве char[] ch от int start до int length
В тела этих методов мы пишем код, который хотим, чтобы выполнялся во время наступлений этих событий
 */