package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Order;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdAddOrder extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String passportId = req.getParameter("PassportID");
            String orderDate = req.getParameter("StartDate");
            String returnDate = req.getParameter("ReturneDate");
            String surname = req.getParameter("Surname");
            String name = req.getParameter("Name");
            String middleName = req.getParameter("MiddleName");
            String address = req.getParameter("Address");
            Order order = new Order(0, passportId, orderDate, returnDate, surname,
                    name, middleName, address, 2);
            Dao dao = Dao.getDao();
            dao.order.create(order);
            return Action.ADDORDERDONE.cmd;
        }
        return null;
    }
}
