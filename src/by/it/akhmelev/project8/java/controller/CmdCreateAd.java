package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.beans.Ad;
import by.it.akhmelev.project8.java.beans.User;
import by.it.akhmelev.project8.java.dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdCreateAd extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException, IOException, ServletException {
        if (Util.getUser(req) == null)
            return Action.LOGIN.cmd;
        if (Form.isPost(req)) {
            User user = Util.getUser(req);
            String description = Form.getString(req, "description");
            String address = Form.getString(req, "address");
            int rooms = Form.getInt(req, "rooms");
            int floor = Form.getInt(req, "floor");
            int floors = Form.getInt(req, "floors");
            double price = Form.getDouble(req, "price");
            double area = Form.getDouble(req, "area");
            Ad ad = new Ad(0, description, address, rooms, floor, floors, price, area, user.getId());
            Dao.getDao().ad.create(ad);
            Util.saveImage(req,"ad"+ad.getId());
            return Action.PROFILE.cmd;
        }
        return null;
    }
}
