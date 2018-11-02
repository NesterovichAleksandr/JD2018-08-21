package by.it.litvin.project.java.controller;

import by.it.litvin.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        req.setAttribute("forms", Dao.getDao().form.getAll(""));
        return null;
    }
}
