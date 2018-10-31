package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd{
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if(req.getMethod().equalsIgnoreCase("post")) {
            System.out.println("ENTER IF!!!!");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE login='%s' AND password='%s'", login, password);
            List<User> users = dao.user.getAll(where);
            System.out.println("LIST CREATED!!!!");
            if (users.size() > 0) {
                req.setAttribute("user", users.get(0));
            }
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        String where = String.format(" WHERE login='%s' AND password='%s'", "user1", "users1password");
        List<User> all = Dao.getDao().user.getAll(where);
        System.out.println(all.get(0));
    }
}
