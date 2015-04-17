package net.Horstmann_Example_T2.Chapter2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

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

public class App09_XML_DOM_BuildAndWrite_Simple {
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        File settingsFile = new File("C:\\GcstMapDownloader\\Settings.xml");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.newDocument();

        Element settings = doc.createElement("settings");

        Element program_settings = doc.createElement("program_settings");
        Element authorization = doc.createElement("authorization");

        Element login = doc.createElement("login");
        Text loginText = doc.createTextNode("kharmet");
        login.appendChild(loginText);

        Element password = doc.createElement("password");
        Text passwordText = doc.createTextNode("9NCzR##?3z");
        password.appendChild(passwordText);

        authorization.appendChild(login);
        authorization.appendChild(password);

        program_settings.appendChild(authorization);

        Element patterns = doc.createElement("patterns");

        Element pattern = doc.createElement("pattern");

        Element map_name = doc.createElement("map_name");
        Text map_nameText = doc.createTextNode("Микрокольцовка");
        map_name.appendChild(map_nameText);

        Element map_header = doc.createElement("map_header");
        Text map_headerText = doc.createTextNode("QYUA98");
        map_header.appendChild(map_headerText);

        pattern.appendChild(map_name);
        pattern.appendChild(map_header);

        patterns.appendChild(pattern);

        settings.appendChild(program_settings);
        settings.appendChild(patterns);

        doc.appendChild(settings);

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
        transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(settingsFile)));
    }
}

