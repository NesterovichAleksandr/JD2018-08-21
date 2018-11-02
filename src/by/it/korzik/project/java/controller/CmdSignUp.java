package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdSignUp extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Util.updateAll(req);
        if (Form.isPost(req)) {
            DAO dao = DAO.getDAO();
            String userName = Form.getString(req, "username");
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email");
            long roleID = Form.getLong(req, "roles_id");
            Users user = new Users(0, userName, login, password, email, roleID);
            dao.user.create(user);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
