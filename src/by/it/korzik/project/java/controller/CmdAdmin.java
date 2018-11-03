package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdAdmin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        DAO dao = DAO.getDAO();
        Users admin = Util.getUser(req);
        if (admin == null) {
            return Action.LOGIN.cmd;
        }
        Util.updateAll(req);


        if (Form.isPost(req)) {
            if (req.getParameter("Reset") != null) {
                dao.reset();
                Util.updateAll(req);
                return null;
            }
            long id = Form.getLong(req, "id");
            String username = Form.getString(req, "username");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            long roles_Id = Form.getLong(req, "roles_id");
            Users user = new Users(id, username, login, password, email, roles_Id);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
                Util.updateAll(req);
            }
            if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
                Util.updateAll(req);
            }
        }
        return null;
    }
}
