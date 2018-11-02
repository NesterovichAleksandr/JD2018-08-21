package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdEditUsers extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Dao dao = Dao.getDao();
        User admin = Util.getUser(req);
        if (admin == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)) {
            long id = Long.valueOf(Form.getString(req, "id"));
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email");
            String passpostSeries = Form.getString(req, "passpostSeries");
            int passportId = Integer.parseInt(Form.getString(req, "passportId"));
            String bancardNumber = Form.getString(req, "bancardNumber");
            int cid = Integer.parseInt(Form.getString(req, "cid"));
            long roles_id = Long.valueOf(Form.getString(req, "roles_id"));
            User user = new User(id, login, password, email, passpostSeries, passportId, bancardNumber, cid, roles_id);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
            }
            if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
            }
        }
        req.getServletContext().setAttribute("roles", dao.role.getAll());
        req.setAttribute("users", dao.user.getAll());
        return null;
    }
}




