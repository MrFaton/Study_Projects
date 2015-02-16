package net.Horstmann_Example_T2.Chapter2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.Horstmann_Example_T2.Chapter2.Files.Card;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by root on 16.02.2015.
 */
public class App05_XML_DOM_Write_V1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException, TransformerException {
        File file = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\CardList.ser");
        File outputXML1 = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\XML1.xml");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        ArrayList<Card> list = (ArrayList) in.readObject();
        in.close();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element cards = doc.createElement("cards");
        Element card = doc.createElement("card");
        cards.appendChild(card);
        Element engWord = doc.createElement("word");
        card.appendChild(engWord);
        Text engWordText = doc.createTextNode(list.get(0).getEngWord());
        engWord.appendChild(engWordText);


//        cards.appendChild(card.appendChild(engWord.appendChild(engWordText)));
        doc.appendChild(cards);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "systemIdentifier");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "publicIdentifier");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(outputXML1)));
    }
}
