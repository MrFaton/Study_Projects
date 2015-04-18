package net.Horstmann_Example_T2.Chapter2_XML;

import net.Horstmann_Example_T2.Chapter2_XML.Files.Card;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by root on 16.02.2015.
 */
public class App07_XML_DOM_Writer_V2 {
    private static Element cards;
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document doc;
    private static File cardListFile;
    private static Path outputXML1;

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException,
            SAXException, TransformerException {
        cardListFile = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2_XML\\Files\\CardList.ser");
        outputXML1 = Paths.get(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2_XML\\Files\\XML2(recorded_by_App07).xml");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(cardListFile));
        ArrayList<Card> listOfCards = (ArrayList) in.readObject();
        in.close();
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        cards = doc.createElement("cards");
        for (Card cardFromList : listOfCards) {
            addCardToXML(cardFromList);
        }
        doc.appendChild(cards);
        writeXML();
    }

    public static void addCardToXML(Card cardFormList) {
        Element card = doc.createElement("card");

        Element engWord = doc.createElement("word");
        Text engWordText = doc.createTextNode(cardFormList.getEngWord());
        engWord.appendChild(engWordText);

        Element meanings = doc.createElement("meanings");

        Element guess_num = doc.createElement("guess_num");
        Text guess_numWord = doc.createTextNode(cardFormList.getNumOfGuess() + "");
        guess_num.appendChild(guess_numWord);
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

    //запись в файл при помощи интерфайса LSSerializer
    public static void writeXML() throws IOException {
        //получаем класс, реализующий инрфейс LSSerializer
        DOMImplementation impl = doc.getImplementation();
        DOMImplementationLS implLs = (DOMImplementationLS) impl.getFeature("LS", "3.0");
        LSSerializer ser = implLs.createLSSerializer();
        //вводит в документ пробелы и разрывы строк
        ser.getDomConfig().setParameter("format-pretty-print", true);
//        String str = ser.writeToString(doc);//преобразовывает документ в символьную строку
        //записывает документ в файл
        LSOutput out = implLs.createLSOutput();
        out.setEncoding("UTF-8");
        out.setByteStream(Files.newOutputStream(outputXML1));
        ser.write(doc, out);
    }
}
/*
Этот класс такой же как и App06_XML_DOM_Writer_V1, только у этого класса отличается метод записи сформированного
докумета в файл
 */