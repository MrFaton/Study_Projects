package net.Horstmann_Example_T2.Chapter2;

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
        File file = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\TestPage1In.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);

        XPathFactory xpfactory = XPathFactory.newInstance();
        XPath path = xpfactory.newXPath();

        System.out.println("Всего карточек: " + path.evaluate("count (/cards/card)", doc));

        String text = path.evaluate("/cards/card[2]/word", doc);
        System.out.println("Английское слово второй карточки: " + text);

        text = path.evaluate("/cards/card[3]/meanings/translations/word[2]", doc);
        System.out.println("Второй слово превода из третьей карточки: " + text);
        System.out.println("какие словам там вообще есть: ");
        NodeList nodes = (NodeList) path.evaluate("/cards/card[3]/meanings/translations/word", doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getTextContent());
        }
    }
}
