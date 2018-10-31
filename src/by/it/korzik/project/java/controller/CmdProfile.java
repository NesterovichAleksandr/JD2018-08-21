package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Orders;
import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Users user = Util.getUser(req);
        if (user==null){
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)&&req.getParameter("logoutbutton")!=null){
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.LOGIN.cmd;
        }
        if (user != null) {
            List<Orders> orders = DAO.getDAO().order.getAll(" WHERE `orders`.`users_id`=" + user.getId());
            HttpSession session = req.getSession();
            session.setAttribute("orders", orders);
        }
        return null;
    }
}
