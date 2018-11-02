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
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) throws SQLException {
        Roleparam user = util.getUser(req);
        if (user ==null)
            return  Action.LOGIN.cmd;
        if (Form.isPost(req) && req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.LOGIN.cmd;
        }

        if (user != null) {
            List<Ads> ads = Dao.getDao().ad.getALL(" WHERE `ads`.`roleparam_id`=" + user.getId());
            HttpSession session = req.getSession();
            session.setAttribute("ads", ads);
            //return Action.PROFILE.cmd;
        }
            return null;
    }
}
