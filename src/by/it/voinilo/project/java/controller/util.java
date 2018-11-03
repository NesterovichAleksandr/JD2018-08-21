package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Roleparam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class util {
    static Roleparam getUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (Roleparam) oUser;
            }

        }
        return null;
    }

}