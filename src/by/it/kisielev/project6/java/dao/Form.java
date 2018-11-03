package by.it.kisielev.project6.java.dao;

import javax.servlet.http.HttpServletRequest;

public class Form {
    static  boolean isPost(HttpServletRequest req){
        return  req.getMethod().equalsIgnoreCase("post");
    }
    static boolean isGet(HttpServletRequest req){
        return  req.getMethod().equalsIgnoreCase("get");
    }
    static boolean get (HttpServletRequest request, String name){
        return  get(request,name, "")
    }

    static  boolean
}
