package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdSignUp extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = Form.getLogin(req, "Login");
//            String login = req.getParameter("Login");
            String password = Form.getPassword(req, "Password");
//            String password = req.getParameter("Password");
            String email = Form.getEmail(req, "Email");
//            String email = req.getParameter("Email");
            User user = new User(0, login, password, email, 2);
            if (testLogin(user)) {
                String loginExeption = "Login: \"" + login + "\" exist.";
                req.setAttribute("loginExeption", loginExeption);
                return Action.SIGNUP.cmd;
            }
            Dao dao = Dao.getDao();
            dao.user.create(user);
            return Action.SIGNUPDONE.cmd;
        }
        return null;
    }

    private boolean testLogin(User testUser) throws SQLException {
        String testLogin = testUser.getLogin();
        Dao dao = Dao.getDao();
        List<User> users = dao.user.getAll();
        for (User user : users) {
            String login = user.getLogin();
            if (login.equals(testLogin))
                return true;
        }
        return false;
    }
}
