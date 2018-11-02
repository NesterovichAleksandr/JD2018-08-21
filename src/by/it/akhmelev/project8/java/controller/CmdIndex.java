package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.beans.Ad;
import by.it.akhmelev.project8.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdIndex extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Dao dao = Dao.getDao();
        int adcount = dao.ad.getAll().size();
        req.setAttribute("adcount", adcount);
        Integer start = 0;
        try {
            start = Form.getInt(req, "start");
        } catch (ParseException e) {
        }
        String where = String.format(" LIMIT %s, 10",start);
        List<Ad> ads = dao.ad.getAll(where);
        req.setAttribute("ads", ads);

        return null;
    }
}
