package by.it.korzik.jd02.jd02_09;

import by.it.korzik.jd02.jd02_09.beans.Persons;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Object obj = unmarshaller.unmarshal(new File(Path.getXML()));
            Persons persons = (Persons) obj;
            System.out.println(persons);
        } catch (JAXBException e) {
            System.out.println("a");
            e.printStackTrace();
        }
    }
}
