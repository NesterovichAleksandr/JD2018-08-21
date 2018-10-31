package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdSignUp extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (Form.isPost(req)){
            DAO dao = DAO.getDAO();
            String userName = req.getParameter("username");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            long roleID = Long.parseLong(req.getParameter("role_id"));
            Users user = new Users(0, userName, login, password, email, roleID);
            dao.user.create(user);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
