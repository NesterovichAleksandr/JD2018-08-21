package by.it.kisielev.jd02_09;

import org.omg.CORBA.Object;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class TaskA {
    public static void main(String[] args) {
      try {
          JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
          Unmarshaller unmarshaller=context.createUnmarshaller();
          Object o= unmarshaller.unmarshal(new File(Path.get))
    }
    }
}
