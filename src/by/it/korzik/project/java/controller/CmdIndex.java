package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Util.updateAll(req);
        return null;
    }
}
