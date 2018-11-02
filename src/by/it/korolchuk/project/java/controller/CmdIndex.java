package by.it.korolchuk.project.java.controller;

import by.it.korolchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdIndex extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
       req.setAttribute("ads", Dao.getDao().ad.getAll(""));
        return null;
    }

}
