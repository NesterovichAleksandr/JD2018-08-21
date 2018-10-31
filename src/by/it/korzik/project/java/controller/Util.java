package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {

    static Users getUser(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if (session!=null){
            Object objUser = session.getAttribute("user");
            if (objUser!=null){
                return (Users)objUser;
            }
        }
        return null;
    }
}
