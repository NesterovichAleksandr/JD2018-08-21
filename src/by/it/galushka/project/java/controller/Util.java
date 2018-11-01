package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Car;
import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

class Util {

    static User getUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (User) oUser;
            }
        }
        return null;
    }

    static Car getCar(HttpServletRequest req) throws ParseException, SQLException {
        long id = Form.getLong(req, "carList");
        String where = String.format(" WHERE `ID`=%d", id);
        Dao dao = Dao.getDao();
        List<Car> cars = dao.car.getAll(where);
        if (cars.size() > 0) {
            Car car = cars.get(0);
            return car;
        }
        throw new ParseException("Не находит ID маштны!",0);
    }
}
