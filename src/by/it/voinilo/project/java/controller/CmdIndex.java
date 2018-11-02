package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.entitydao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdIndex extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) throws SQLException {
        req.setAttribute("ads", Dao.getDao().ad.getALL());
        return null;
    }
}
