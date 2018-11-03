package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Ads;
import by.it.voinilo.project.java.beans.Roleparam;
import by.it.voinilo.project.java.entitydao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdProfile extends Cmd {
    Dao dao = Dao.getDao();
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) throws SQLException {
        Roleparam user = util.getUser(req);
        if (user ==null)
            return  Action.LOGIN.cmd;
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

        List<Ads> forms = Dao.getDao().ad.getALL(" WHERE `ads`.`roleparam_id`=" + user.getId());
        HttpSession session = req.getSession();
        session.setAttribute("ads", forms);
        return null;

    }
}
