package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Ads;
import by.it.voinilo.project.java.entitydao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdSearch extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) throws SQLException {
        if (Form.isPost(req)) {
            if (req.getParameter("search") != null) {


                List<Ads> forms = Dao.getDao().ad.getALL(" WHERE `ads`.`name`=" + req.getParameter("searchreq"));
                HttpSession session = req.getSession();
                session.setAttribute("ads", forms);
                return Action.SEARCH.cmd;

            }
        }
        return null;
    }
}
