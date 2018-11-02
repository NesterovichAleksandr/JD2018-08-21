package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Car;
import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdEditCarList extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Dao dao = Dao.getDao();
        User admin = Util.getUser(req);
        if (admin == null)
            return Action.LOGIN.cmd;
        if (admin.getID() == 1 && Form.isPost(req)) {
            Car car;
            if (req.getParameter("editCar") != null) {
                car = getCar(req);
                dao.car.update(car);
            }
            if (req.getParameter("deleteCar") != null) {
                car = getCar(req);
                dao.car.delete(car);
            }
        }
        req.setAttribute("cars", dao.car.getAll());
        return null;
    }

    private Car getCar(HttpServletRequest req) throws ParseException {
        long id = Form.getLong(req, "ID");
        String mark = req.getParameter("Mark");
        String model = req.getParameter("Model");
        String color = req.getParameter("Color");
        String engineCapacity = req.getParameter("EngineCapacity");
        double eC = Double.parseDouble(engineCapacity);
        String releaseDate = req.getParameter("ReleaseDate");
        String reserved = req.getParameter("Reserved");
        return new Car(id, mark, model, color, eC, releaseDate, reserved, 1);
    }
}
