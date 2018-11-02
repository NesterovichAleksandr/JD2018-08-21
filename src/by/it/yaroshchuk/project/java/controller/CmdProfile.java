package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);
        if(user == null)
            return Action.LOGIN.cmd;
        if(Form.isPost(req)) {
            user.setLogin(Form.getString(req, "login"));
            user.setPassword(Form.getString(req, "password"));
            user.setEmail(Form.getString(req, "email"));
            Dao.getDao().user.update(user);
        } else if (req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.LOGIN.cmd;
        }


        return null;
    }
}
