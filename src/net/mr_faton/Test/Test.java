package net.mr_faton.Test;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class Test {
    public static void main(String[] args) throws URISyntaxException {
        File settingsFile = new File("C:\\GcstMapDownloader\\Settings.xml");
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document docToRead = documentBuilder.parse(settingsFile);

            Node loginNode = docToRead.getElementsByTagName("login").item(0).getFirstChild();
            loginNode.setNodeValue("blblblblbllbbb");
            saveSettings(docToRead, settingsFile);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }

    }
    private static void saveSettings(Document docToWrite, File file) {
        try(FileOutputStream fileOutput = new FileOutputStream(file)) {
            //построить холостое преобразование
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //установить отступ
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            //выполнить холостое преобразование и вывести узел в файл
            transformer.transform(new DOMSource(docToWrite), new StreamResult(fileOutput));
        } catch (IOException | TransformerException ex) {
            ex.printStackTrace();
        }
    }
}
/*
Узнать корневую рабочую папку для проекта или jar файла
 */