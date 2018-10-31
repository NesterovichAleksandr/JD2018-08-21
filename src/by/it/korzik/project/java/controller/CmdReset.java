package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdReset extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) {
            req.setAttribute("a","a");
            DAO dao = DAO.getDAO();
            dao.reset();

        return null;
    }
}
