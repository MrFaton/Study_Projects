package net.Horstmann_Example_T2.Chapter2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by root on 16.02.2015.
 */
public class App03_StreamSAX_Analyzer_V1 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String url;
        if (args.length == 0) {
            url = "http://www.w3.org/";
        } else {
            url = args[0];
        }

        DefaultHandler myHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (localName.equals("a") && attributes != null) {
                    for (int i = 0; i < attributes.getLength(); i++) {
                        String name = attributes.getLocalName(i);
                        if (name.equals("href")) {
                            System.out.println(attributes.getValue(i));
                        }
                    }
                }
            }
        };

        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        saxFactory.setNamespaceAware(true);
        saxFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        SAXParser saxParser = saxFactory.newSAXParser();
        InputStream in = new URL(url).openStream();
        saxParser.parse(in, myHandler);
    }
}
