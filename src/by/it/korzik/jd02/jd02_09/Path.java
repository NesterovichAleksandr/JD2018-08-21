package by.it.korzik.jd02.jd02_09;

public class Path {
    private Path(){}
   static String getXML(){
        String path = System.getProperty("user.dir");
        return path+"/src/by/it/korzik/jd02/jd02_09/Persons+XSD.xml";
    }
}
