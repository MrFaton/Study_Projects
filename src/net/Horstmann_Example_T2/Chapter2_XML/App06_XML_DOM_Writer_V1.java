package net.Horstmann_Example_T2.Chapter2_XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.Horstmann_Example_T2.Chapter2_XML.Files.Card;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by root on 16.02.2015.
 */
public class App06_XML_DOM_Writer_V1 {
    private static Element cards;
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document doc;
    private static File cardListFile;
    private static File outputXML1;

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException,
            SAXException, TransformerException {
        cardListFile = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2_XML\\Files\\CardList.ser");
        outputXML1 = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2_XML\\Files\\XML1(recorded_by_App06).xml");
        //восстанавливаем список наших карт из сериализированного файла
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(cardListFile));
        ArrayList<Card> listOfCards = (ArrayList) in.readObject();
        in.close();
        //формироуем фабрику и построителя документов
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        //создаём новый документ
        doc = builder.newDocument();
        /*
        создаём элемент cards, который станет корневым для нашего xml-документа. В этот элемент будут вставляться
        все остальные элементы
         */
        cards = doc.createElement("cards");
        //после того, как корневой элемент сформирован, проходим по списку наших карт и каждую карту передаём в метод
        for (Card cardFromList : listOfCards) {
            addCardToXML(cardFromList);
        }
        //после того, как сформированы и упакованы, упаковываем корневой элемент в наш xml-документ
        doc.appendChild(cards);
        //производим запись xml-документа
        writeXML();
    }

    //производит формирование и упаковывание элементов разметки карточки
    public static void addCardToXML(Card cardFormList) {
        //формируем элемент card
        Element card = doc.createElement("card");

        //формируем элемент word, который содержит английское слово
        Element engWord = doc.createElement("word");
        //формируем элемент Text, который является английским словом
        Text engWordText = doc.createTextNode(cardFormList.getEngWord());
        //упаковываем элемент Text в элемент word. Теперь он у нас содержит текст (слово)
        engWord.appendChild(engWordText);

        //формируем элемент meanings
        Element meanings = doc.createElement("meanings");

        //формируем элемент guess_num
        Element guess_num = doc.createElement("guess_num");
        //формируем формируем текстовую состовляющую для элемента guess_num
        Text guess_numWord = doc.createTextNode(cardFormList.getNumOfGuess() + "");
        //упаковываем текст в элемент guess_num
        guess_num.appendChild(guess_numWord);
        //упаковываем элемент guess_num в элемент meanings
        meanings.appendChild(guess_num);

        Element translations = doc.createElement("translations");

        for (int i = 0; i < cardFormList.getTranslate().length; i++) {
            Element rusWord = doc.createElement("word");
            Text rusWordText = doc.createTextNode(cardFormList.getTranslate()[i]);
            rusWord.appendChild(rusWordText);
            translations.appendChild(rusWord);
        }
        meanings.appendChild(translations);

        Element examples = doc.createElement("examples");

        for (int i = 0; i < cardFormList.getExample().length; i++) {
            Element example = doc.createElement("example");
            Text exampleWord = doc.createTextNode(cardFormList.getExample()[i]);
            example.appendChild(exampleWord);
            examples.appendChild(example);
        }
        meanings.appendChild(examples);

        if (cardFormList.getSound().length() > 3) {
            Element sound = doc.createElement("sound");
            sound.setAttribute("name", cardFormList.getSound());
            meanings.appendChild(sound);
        }
        card.appendChild(engWord);
        card.appendChild(meanings);
        cards.appendChild(card);
    }

    //записывает документ в файл
    public static void writeXML() throws TransformerException, FileNotFoundException {
        //построить холостое преобразование
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        //установить свойства вывода, чтобы получить узел DOCTYPE
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "systemIdentifier");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "publicIdentifier");
        //установить отступ
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        //выполнить холостое преобразование и вывести узел в файл
        transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(outputXML1)));
    }
}
/*
Класс производит запись xml-документа на основе списка из трёх экземпляров класса Card.
Наш класс пытается воссоздать xml-документ, созданный вручную (TestPage1In.xml) и результат его работы - это файл
XML1(recorded_by_App06).xml

Смысл этой всей структуры в том, что мы создаём элементы разметки и упаковываем их друг в друга (вставляем друг в друга)
и записываем в файл
 */