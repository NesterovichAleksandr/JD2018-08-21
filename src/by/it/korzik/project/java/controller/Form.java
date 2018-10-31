package by.it.korzik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {


    public static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("post");
    }

}

