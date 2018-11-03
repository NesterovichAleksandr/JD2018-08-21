package by.it.kisielev.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<String> key = new ArrayList<>();

    public  void put (String name){ key.add(name); }

    List<String> getKey(){ return key; }
}
