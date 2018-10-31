package by.it.litvin.project.java.controller;


import by.it.litvin.project.java.dao.Dao;
import by.it.litvin.project.java.dao.beans.Form;
import by.it.litvin.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);
        if (user == null)
            return Action.LOGIN.cmd;

        if (Forms.isPost(req) && req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.LOGIN.cmd;
        }
        if (user != null) {
            List<Form> forms = Dao.getDao().form.getAll(" WHERE `forms`.`users_id`=" + user.getId());
            HttpSession session = req.getSession();
            session.setAttribute("forms", forms);
        }
        return null;
    }
}
