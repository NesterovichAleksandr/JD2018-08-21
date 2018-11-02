package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Roleparam;
import by.it.voinilo.project.java.entitydao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignUp extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) throws Exception {
        if (Form.isPost(req)) {
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            Roleparam user = new Roleparam(0, login, password, email,2);
            Dao dao = Dao.getDao();
            dao.user.create(user);
            return Action.LOGIN.cmd;
        }
        return null;

    }


}
