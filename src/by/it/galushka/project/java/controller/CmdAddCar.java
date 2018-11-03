package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.Car;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdAddCar extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String mark = req.getParameter("Mark");
            String model = req.getParameter("Model");
            String color = req.getParameter("Color");
            String engineCapacity = req.getParameter("EngineCapacity");
            double eC = Double.parseDouble(engineCapacity);
            String releaseDate = req.getParameter("ReleaseDate");
            String reserved = req.getParameter("Reserved");
            Car car = new Car(0, mark, model, color, eC, releaseDate, reserved, 1);
            Dao dao = Dao.getDao();
            dao.car.create(car);
            return Action.PROFILE.cmd;
        }
        return null;
    }
}
