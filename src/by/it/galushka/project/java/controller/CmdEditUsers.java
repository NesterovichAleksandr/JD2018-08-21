package by.it.galushka.project.java.controller;

import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdEditUsers extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Dao dao = Dao.getDao();
        User admin = Util.getUser(req);
        if (admin == null)
            return Action.LOGIN.cmd;
        long idAdmin = admin.getID();
        if (idAdmin == 1 && Form.isPost(req)){
            long idUser = Form.getLong(req, "ID");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            long rolesId = Form.getLong(req, "rolesId");
            User user = new User(idUser, login, password, email, rolesId);
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
