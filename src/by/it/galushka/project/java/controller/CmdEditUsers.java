package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdEditUsers extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Dao dao = Dao.getDao();
        User admin = Util.getUser(req);
        if (admin == null)
            return Action.LOGIN.cmd;
        long id = admin.getID();
        if (id == 1 && Form.isPost(req)){
            String userId = req.getParameter("ID");
            id = Long.valueOf(userId);
            String login = req.getParameter("Login");
            String password = req.getParameter("Password");
            String email = req.getParameter("Email");
            String roles = req.getParameter("roles_Id");
            Long rolesId = Long.valueOf(roles);
            User user = new User(id, login, password, email, rolesId);
            if (req.getParameter("Update") != null)
                dao.user.update(user);
            if (req.getParameter("Delete") != null)
                dao.user.delete(user);
        }
        req.setAttribute("users", dao.user.getAll());
        req.setAttribute("roles", dao.role.getAll());
        return null;
    }
}
