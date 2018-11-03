package by.it.kisielev.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Good {

     private  static Map<String, Double> goodMap=new HashMap<>();

     static {
         goodMap.put("tea ",7.00);
         goodMap.put("sugar ",10.20);
         goodMap.put("sausage ",15.10);
         goodMap.put("long loaf ",3.00);
         goodMap.put("chocolate ",2.00);
     }






     static Set<String> goodsKeySet(){ return  goodMap.keySet(); }
}
