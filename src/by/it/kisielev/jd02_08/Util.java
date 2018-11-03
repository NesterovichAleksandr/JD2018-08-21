package by.it.kisielev.jd02_08;

public class Util {
    private Util(){
    }

    static String xml(){
        String root = System.getProperty("user.dir");
        String xml = "/src/by/it/kisielev/jd02_07/Books.xml";
        return root + xml;
    }
}

