package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Car;
import by.it.galushka.project.java.beans.Order;
import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdAddOrder extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            User user = Util.getUser(req);
            String passportId = req.getParameter("PassportID");
            String orderDate = req.getParameter("StartDate");
            String returnDate = req.getParameter("ReturneDate");
            String surname = req.getParameter("Surname");
            String name = req.getParameter("Name");
            String middleName = req.getParameter("MiddleName");
            String address = req.getParameter("Address");
            Order order = new Order(0, passportId, orderDate, returnDate, surname,
                    name, middleName, address, user.getID());
            Dao dao = Dao.getDao();
            dao.order.create(order);

//            ================== update car list (Reserved car) =============

            Car car = Util.getCar(req);
            car.setReserved("true");
            dao.car.update(car);

//            ===============================================
            HttpSession session = req.getSession();
            List<Car> cars = Dao.getDao().car.getAll();
            session.setAttribute("cars", cars);

            return Action.PROFILE.cmd;
        }
        return null;
    }
}
