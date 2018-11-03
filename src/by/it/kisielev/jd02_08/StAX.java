package by.it.kisielev.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAX {
    private static String tab = "";
    private static StringBuilder buffer = new StringBuilder();

    public static void main(String[] args) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream xml = new FileInputStream(Util.xml())) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(xml);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        start(reader);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        characters(reader);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        stop(reader);
                        break;
                }
            }
    }catch (XMLStreamException | IOException e){
            e.printStackTrace();
        }
    }

    private static void stop(XMLStreamReader reader) {
        if (buffer.length() > 0)
            System.out.println(tab + buffer.toString());
        buffer.setLength(0);
        tab = tab.substring(1);
        System.out.println(tab + "</" + reader.getLocalName() + ">");
    }

    private static void characters(XMLStreamReader reader) {
        String part = reader.getText();
        buffer.append(part.trim());
    }

    private static void start(XMLStreamReader reader) {
        int length = reader.getAttributeCount();
        System.out.print(tab + "< " + reader.getLocalName());
        if(length>0) {
            for (int j = 0; j < length; j++) {
                String name = reader.getAttributeLocalName(j);
                String value = reader.getAttributeValue(j);
                System.out.print(" " + name + " = " + value);
            }
        }
        System.out.println(" >");
        tab = "\t" + tab;
        buffer.setLength(0);
    }
}
