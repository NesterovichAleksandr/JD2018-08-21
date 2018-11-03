package by.it.kisielev.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM {

    public static void main(String[] args) {
        String File="src/by/it/kisielev/jd02_07/BooksXSD.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder =factory.newDocumentBuilder();
            Document doc= builder.parse(File);
            Element ElementsDoc = doc.getDocumentElement();
            printDom("", ElementsDoc);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.print("Проверь код  " + e.toString());
        }
    }

    private static void printDom(String quotes, Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(quotes + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap list = node.getAttributes();
                for (int i = 0; i < list.getLength(); i++) {
                    System.out.print(" " + list.item(i).getNodeName() + "=\"" + list.item(i).getNodeValue() + "\"");
                }
            }
            System.out.println(">");
        }else{
            if (node.getTextContent().trim().length()>0){
                System.out.println(quotes + node.getTextContent().trim());
            }
        }
        NodeList nodeList=node.getChildNodes();
        for (int i = 0; i <nodeList.getLength() ; i++) {
            printDom(quotes + "\t", nodeList.item(i));
        }
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(quotes + "</" + node.getNodeName() + ">");
        }
    }
}
