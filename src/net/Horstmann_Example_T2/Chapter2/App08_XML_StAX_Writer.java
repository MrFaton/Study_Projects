package net.Horstmann_Example_T2.Chapter2;

import net.Horstmann_Example_T2.Chapter2.Files.Card;

import java.io.*;
import javax.xml.stream.*;
import java.util.*;

/**
 * Created by Mr_Faton on 18.02.2015.
 */
public class App08_XML_StAX_Writer {
    private static File outputXML;
    private static File cardListFile;
    private static XMLOutputFactory factory;
    private static XMLStreamWriter writer;

    public static void main(String[] args) throws IOException, XMLStreamException, ClassNotFoundException {
        outputXML = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\XML3(recorded_by_App08).xml");
        cardListFile = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\CardList.ser");
        //создаём фабрику и поток вывода в файл
        factory = XMLOutputFactory.newInstance();
        writer = factory.createXMLStreamWriter(new BufferedOutputStream(new FileOutputStream(outputXML)));
        //загружаем из сериализированного файла наш список кароточек
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(cardListFile));
        ArrayList<Card> listOfCards = (ArrayList) in.readObject();
        in.close();

        //записываем открывающийся элемент документа
        writer.writeStartDocument();
        //записываем открывающийся корневой элемент cards
        writer.writeStartElement("cards");
        for (Card cardFromList : listOfCards) {
            //передаём каждую карту в метод
            writeCardElement(cardFromList);
        }
        //записываем закрывающийся корнеовй элемент cards
        writer.writeEndElement();
        //записываем закрывающийся элемент документа
        writer.writeEndDocument();
        //збрасываем все буфера и закрываем поток
        writer.flush();
        writer.close();
    }

    //записывает карты в xml-документ
    public static void writeCardElement(Card cardFromList) throws XMLStreamException {
        //записываем открывающийся элемент card
        writer.writeStartElement("card");

        //записываем открывающийся элемент word
        writer.writeStartElement("word");
        //добавляем текст к элементу word
        writer.writeCharacters(cardFromList.getEngWord());
        //записываем закрывающийся элемент word
        writer.writeEndElement();

        //записываем открывающийся элемент meanings
        writer.writeStartElement("meanings");

        //записываем открывающийся элемент guess_num
        writer.writeStartElement("guess_num");
        //добавляем текст к элементу guess_num
        writer.writeCharacters(cardFromList.getNumOfGuess() + "");
        //записываем закрывающийся элемент guess_num
        writer.writeEndElement();

        writer.writeStartElement("translations");
        for (int i = 0; i < cardFromList.getTranslate().length; i++) {
            writer.writeStartElement("word");
            writer.writeCharacters(cardFromList.getTranslate()[i]);
            writer.writeEndElement();
        }
        writer.writeEndElement();

        writer.writeStartElement("examples");
        for (int i = 0; i < cardFromList.getExample().length; i++) {
            writer.writeStartElement("example");
            writer.writeCharacters(cardFromList.getExample()[i]);
            writer.writeEndElement();
        }
        writer.writeEndElement();

        if (cardFromList.getSound().length() > 3) {
            writer.writeEmptyElement("sound");
            writer.writeAttribute("name", cardFromList.getSound());
        }

        writer.writeEndElement();
        writer.writeEndElement();
    }
}
/*
Этот класс формирует и записывает xml-документ сразу в файл. Но записанная инфомация не имее от отступов. Если резельтат
открыть блокнотом, то всё будет в строчку. Если браузером, то всё будет выглядеть номально
 */