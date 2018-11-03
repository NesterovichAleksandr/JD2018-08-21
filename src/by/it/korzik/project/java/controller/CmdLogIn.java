package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdLogIn extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (Form.isPost(req)) {
            DAO dao = DAO.getDAO();
            String format = String.format("WHERE email='%s' AND password='%s'", req.getParameter("email"), req.getParameter("password"));
            List<Users> all = dao.user.getAll(format);
            if (all.size() > 0) {
                HttpSession session = req.getSession();
                session.setAttribute("user",all.get(0));
                return Action.PROFILE.cmd;
            }
        }
        return null;
    }
}
