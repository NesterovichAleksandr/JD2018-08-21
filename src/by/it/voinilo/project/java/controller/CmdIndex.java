package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Ads;
import by.it.voinilo.project.java.entitydao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) throws SQLException, ParseException {
        Dao dao = Dao.getDao();
        int adcount = dao.ad.getALL().size();
        req.setAttribute("adcount", adcount);
        Integer start = 0;
        try {
            start = Form.getInt(req, "start");
        } catch (ParseException e) {
        }
        if (start == null) {
            start = 0;
        }
        String where = String.format(" LIMIT %s, 8",start);
        List<Ads> ads = dao.ad.getALL(where);
        req.setAttribute("ads", ads);
        return null;
    }
}
