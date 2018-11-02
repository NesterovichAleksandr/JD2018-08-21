package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.Route;
import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdEditRoutes extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Dao dao = Dao.getDao();
        User admin = Util.getUser(req);
        if (admin == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)) {
            long id = Long.valueOf(Form.getString(req, "id"));
            String city = Form.getString(req, "city");
            Route route = new Route(id, city);
            if (req.getParameter("Update") != null) {
                dao.route.update(route);
            }
            if (req.getParameter("Delete") != null) {
                dao.route.delete(route);
            }
        }
        req.setAttribute("routes", dao.route.getAll());
        return null;
    }
}
