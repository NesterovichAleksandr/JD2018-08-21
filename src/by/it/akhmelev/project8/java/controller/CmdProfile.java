package by.it.akhmelev.project8.java.controller;


import by.it.akhmelev.project8.java.beans.Ad;
import by.it.akhmelev.project8.java.beans.User;
import by.it.akhmelev.project8.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdProfile extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);
        if (user == null)
            return Action.LOGIN.cmd;

        if (Form.isPost(req)) {
            if (req.getParameter("update") != null) {
                user.setLogin(req.getParameter("login"));
                user.setEmail(req.getParameter("email"));
                user.setPassword(req.getParameter("password"));
                Dao.getDao().user.update(user);
            } else if (req.getParameter("logout") != null) {

                HttpSession session = req.getSession();
                session.invalidate();
                return Action.LOGIN.cmd;
            }
        }


        Dao dao = Dao.getDao();
        String where = " WHERE `ads`.`users_id`=" + user.getId();
        int adcount = dao.ad.getAll(where).size();
        req.setAttribute("adcount", adcount);
        Integer start = 0;
        try {
            start = Form.getInt(req, "start");
        } catch (ParseException e) {
        }
        String limit = String.format(" LIMIT %s, 5", start);
        List<Ad> ads = Dao.getDao().ad.getAll(where + limit);
        HttpSession session = req.getSession();
        session.setAttribute("ads", ads);
        return null;
    }
}
