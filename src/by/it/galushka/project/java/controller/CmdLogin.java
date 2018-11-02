package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (Form.isPost(req)) {
            String login = req.getParameter("Login");
            String password = req.getParameter("Password");
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                HttpSession session = req.getSession();
                session.setAttribute("user", users.get(0));
                return Action.PROFILE.cmd;
            }
        }
        return null;
    }
}
