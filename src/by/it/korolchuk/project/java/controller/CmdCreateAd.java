package by.it.korolchuk.project.java.controller;

import by.it.korolchuk.project.java.dao.Dao;
import by.it.korolchuk.project.java.dao.beans.Ad;
import by.it.korolchuk.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdCreateAd extends  Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {

        if (Util.getUser(req) == null)
            return Action.LOGIN.cmd;
        if (Form.isPost(req)) {
            User user = Util.getUser(req);
            String description = Form.getString(req, "description");
            String kindOfAnimal = Form.getString(req, "kindOfAnimal");
            String greed = Form.getString(req, "greed");
            String sex = Form.getString(req, "sex");
            int age = Form.getInt(req, "age");
            int height = Form.getInt(req, "height");
            String qualities = Form.getString(req, "qualities");
            assert user != null;
            Ad ad = new Ad(0, description, kindOfAnimal, greed, sex, age, height, qualities, user.getId());
            //Dao.getDao().ad.create(ad);
            Dao dao = Dao.getDao();
            dao.ad.create(ad);
            return Action.PROFILE.cmd;
        }
        return null;
    }
}
