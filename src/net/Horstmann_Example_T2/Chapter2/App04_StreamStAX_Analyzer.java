package net.Horstmann_Example_T2.Chapter2;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

/**
 * Created by root on 16.02.2015.
 */
public class App04_StreamStAX_Analyzer {
    public static int count = -1;

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        File file = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\TestPage1In.xml");
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(in);
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_DOCUMENT: {
                    System.out.println("Начало XML-документа>>");
                    count++;
                    break;
                }
                case XMLStreamConstants.START_ELEMENT: {
                    System.out.println(spaces() + reader.getName() + ">>");
                    //распечать все атрибуты и их значения, если есть
                    for (int i = 0; i < reader.getAttributeCount(); i++) {
                        System.out.println(spaces() + "Атрибут: " + reader.getAttributeName(i) + " = " + reader.getAttributeValue(i));
                    }
                    count++;
                    break;
                }
                case XMLStreamConstants.CHARACTERS: {
                    System.out.println(spaces() + reader.getText().trim());
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    count--;
                    System.out.println(spaces() + "<<" + reader.getName());
                    break;
                }
                case XMLStreamConstants.END_DOCUMENT: {
                    System.out.println("<<Конец XML-документа");
                    break;
                }
            }
        }
    }

    public static String spaces() {
        String str = "";
        for (int i = 0; i <= count; i++) {
            str += " ";
        }
        return str;
    }
}
