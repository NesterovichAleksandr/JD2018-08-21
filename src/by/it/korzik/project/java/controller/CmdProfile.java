package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Orders;
import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Users user = Util.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }


        if (Form.isPost(req)) {
            if (req.getParameter("update") != null) {
                user.setUserName(Form.getString(req,"username"));
                user.setLogin(Form.getString(req,"login"));
                user.setEmail(Form.getString(req,"email"));
                user.setPassword(Form.getString(req,"password"));
                DAO.getDAO().user.update(user);
            } else if (req.getParameter("logoutbutton") != null) {
                HttpSession session = req.getSession();
                session.invalidate();
                return Action.LOGIN.cmd;
            }
        }
        if (user != null) {
            List<Orders> orders = DAO.getDAO().order.getAll(" WHERE `orders`.`users_id`=" + user.getId());
            HttpSession session = req.getSession();
            session.setAttribute("menu", DAO.getDAO().menu.getAll());
            session.setAttribute("orders", orders);
        }
        return null;
    }
}
