package by.it.korolchuk.project.java.controller;

import by.it.korolchuk.project.java.dao.Dao;
import by.it.korolchuk.project.java.dao.beans.Ad;
import by.it.korolchuk.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdEditAds extends Cmd{

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Dao dao = Dao.getDao();
        User user = Util.getUser(req);
        if (user == null)
            return Action.SIGNUP.cmd;
        if (Form.isPost(req)) {
            long id = Form.getLong(req, "id");
            String description = req.getParameter("description");
            String kindOfAnimal =req.getParameter("kindOfAnimal");
            String greed = req.getParameter("greed");
            String sex = req.getParameter("sex");
            int age = Form.getInt(req, "age");
            int height = Form.getInt(req, "height");
            String qualities = Form.getString(req, "qualities");
            long usersId = Form.getLong(req, "users_id");

            Ad ad = new Ad(id, description, kindOfAnimal, greed, sex, age, height, qualities, usersId);
            if (req.getParameter("Update") != null) {
                dao.ad.update(ad);
            }
            if (req.getParameter("Delete") != null) {
                dao.ad.delete(ad);
            }
        }
        //req.setAttribute("roles", dao.role.getAll());
        //req.setAttribute("users", dao.user.getAll());
        req.setAttribute("ads", dao.ad.getAll("WHERE `ads`.`users_id`=" + user.getId()));
        return null;
    }
}
