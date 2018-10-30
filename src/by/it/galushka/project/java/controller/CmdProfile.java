package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Order;
import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdProfile extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        User user = Util.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }

        if (Form.isPost(req) && req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.LOGIN.cmd;
        }

        if (user != null) {
            List<Order> orders = Dao.getDao().order.getAll(String.format(" WHERE `users_id`= %d ", user.getID()));
            HttpSession session = req.getSession();
            session.setAttribute("orders", orders);
        }

        return null;
    }
}
