package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Car;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdCarList extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Dao dao = Dao.getDao();
        int adcount = dao.car.getAll().size();
        req.setAttribute("adcount", adcount);
        Integer start = 0;
        try {
            start = Form.getInt(req, "start");
        } catch (ParseException e) {
        }
        String limit = String.format(" LIMIT %s, 3", start);
        List<Car> cars = dao.car.getAll(limit);
        HttpSession session = req.getSession();
        session.setAttribute("cars", cars);
        return null;
    }
}
