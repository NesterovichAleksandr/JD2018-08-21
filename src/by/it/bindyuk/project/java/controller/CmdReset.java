package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdReset extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) {
        if (Form.isPost(req) && req.getParameter("reset") != null) {
            Dao.getDao().reset();
        }
        return null;
    }
}
