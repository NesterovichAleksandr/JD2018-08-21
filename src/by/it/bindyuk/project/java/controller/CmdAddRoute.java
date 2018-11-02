package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.Route;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdAddRoute extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            String city = Form.getString(req, "city", Patterns.CITY);
            Route route =  new Route(0,city);
            Dao dao = Dao.getDao();
            dao.route.create(route);
        }
        return null;
    }
}
