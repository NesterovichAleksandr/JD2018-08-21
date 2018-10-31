package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Car;
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

        if (Form.isPost(req)) {
            if (req.getParameter("update") != null) {
                user.setLogin(req.getParameter("login"));
                user.setEmail(req.getParameter("email"));
                user.setPassword(req.getParameter("password"));
                Dao.getDao().user.update(user);
            } else if (req.getParameter("edit") != null) {
                return Action.EDITUSERS.cmd;
            } else if (req.getParameter("logout") != null) {
                HttpSession session = req.getSession();
                session.invalidate();
                return Action.LOGIN.cmd;
            } else if (req.getParameter("editOrders") != null) {
                return Action.EDITORDERS.cmd;
            } else if (req.getParameter("editCarList") != null) {
                return Action.EDITCARLIST.cmd;
            }
        }

        HttpSession session = req.getSession();
        List<Order> orders = Dao.getDao().order.getAll(String.format(" WHERE `users_id`= %d ", user.getID()));
        session.setAttribute("orders", orders);

        List<Car> cars = Dao.getDao().car.getAll();
        session.setAttribute("cars", cars);
        return null;
    }
}
