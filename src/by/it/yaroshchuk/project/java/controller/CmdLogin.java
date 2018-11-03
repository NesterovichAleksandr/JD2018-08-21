package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if(Form.isPost(req)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE login='%s' AND password='%s'", login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                HttpSession session = req.getSession();
                session.setAttribute("user", users.get(0));
                return Action.USERPROFILE.cmd;
            }
        }
        return null;
    }
}
