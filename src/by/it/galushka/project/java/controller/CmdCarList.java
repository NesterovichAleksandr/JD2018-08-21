package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdCarList extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        req.setAttribute("cars", Dao.getDao().car.getAll());
        return null;
    }
}
