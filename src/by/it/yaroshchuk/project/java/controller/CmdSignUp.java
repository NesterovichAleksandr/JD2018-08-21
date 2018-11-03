package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignUp extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            User user = new User(0, login, password, email, 2);
            Dao dao = Dao.getDao();
            dao.user.create(user);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
