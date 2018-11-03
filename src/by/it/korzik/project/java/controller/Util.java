package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

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

    public static void updateAll(HttpServletRequest req) throws SQLException {
        req.setAttribute("roles",DAO.getDAO().role.getAll());
        req.setAttribute("users",DAO.getDAO().user.getAll());
        req.setAttribute("orders",DAO.getDAO().order.getAll());
        req.setAttribute("menu",DAO.getDAO().menu.getAll());
    }
}
