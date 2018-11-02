package by.it.litvin.project.java.controller;

import by.it.litvin.project.java.dao.Dao;
import by.it.litvin.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdEditUsers extends Cmd {

    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Dao dao = Dao.getDao();
        User admin = Util.getUser(req);
        if (admin == null)
            return Action.SIGNUP.cmd;
        if (Forms.isPost(req)) {
            long id = Forms.getLong(req, "id");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            long roles_id = Forms.getLong(req, "roles_id");
            User user = new User(id, login, password, email, roles_id);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
            }
            if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
            }
        }
        req.setAttribute("roles", dao.role.getAll(""));
        req.setAttribute("users", dao.user.getAll(""));
        return null;
    }
}
