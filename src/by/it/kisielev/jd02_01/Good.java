package by.it.kisielev.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Good {

     private  static Map<String, Double> goodMap=new HashMap<>();

     static {
         goodMap.put("чай ",7.00);
         goodMap.put("сахар ",10.20);
         goodMap.put("колбаса ",15.10);
         goodMap.put("батон ",3.00);
         goodMap.put("шоколад ",2.00);
     }

     static Set<String> goodsKeySet(){
         return  goodMap.keySet();
     }
}
