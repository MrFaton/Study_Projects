package net.Horstmann_Example_T2.Chapter2;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

/**
 * Created by root on 16.02.2015.
 */
public class App05_StreamStAX_Analyzer {
    public static int count = -1;

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        File file = new File(System.getProperty("user.dir") + "\\src\\net\\Horstmann_Example_T2\\Chapter2\\Files\\TestPage1In.xml");
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(in);
        //спрашиваем у потока, есть ли слудеющее событие
        while (reader.hasNext()) {
            //сохраняем номер события и прохдим это событие
            int event = reader.next();
            //делаем свитч по номеру события и создаём необходимые нам секции
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
/*
Класс делает то же самое, что и класс App04_StreamSAX_Analyzer_V2, только по другой методике.
Отличие StAX анализатора от SAX анализатора:
SAX-анализатор при наступлении события вызывает соответствующий ему метод
У StAX-анализатора каждому событию соответствует определённое число типа int. Если поставить switch или if на каждое
такое число (которое равно определённому событию), то при наступлении определённого события, мы будем попадать в
соответствующую ему секцию
 */