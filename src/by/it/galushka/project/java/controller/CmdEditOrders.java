package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Order;
import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdEditOrders extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Dao dao = Dao.getDao();
        User user = Util.getUser(req);
        if (user == null)
            return Action.LOGIN.cmd;
        long userId = user.getID();
        if (userId != 1 && Form.isPost(req)) {
            Order order;
            if (req.getParameter("editOrder") != null) {
                order = getOrder(req, user);
                dao.order.update(order);
            }
            if (req.getParameter("deleteOrder") != null) {
                order = getOrder(req, user);
                dao.order.delete(order);
            }
        }
        List<Order> orders = Dao.getDao().order.getAll(String.format(" WHERE `users_id`= %d ", user.getID()));
        HttpSession session = req.getSession();
        session.setAttribute("orders", orders);
        return null;
    }

    private Order getOrder(HttpServletRequest req, User user) throws ParseException {
        long id = Form.getLong(req, "ID");
        String passportId = req.getParameter("PassportID");
        String orderDate = req.getParameter("StartDate");
        String returnDate = req.getParameter("ReturneDate");
        String surname = req.getParameter("Surname");
        String name = req.getParameter("Name");
        String middleName = req.getParameter("MiddleName");
        String address = req.getParameter("Address");
        return new Order(id, passportId, orderDate, returnDate, surname,
                name, middleName, address, user.getID());
    }
}
