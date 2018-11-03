package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Roleparam;
import by.it.voinilo.project.java.entitydao.Dao;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdGotoAdminPage extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) throws SQLException, ParseException {
        Dao dao = Dao.getDao();
        Roleparam admin = util.getUser(req);
        if (admin == null)
            return Action.LOGIN.cmd;
        if (admin.getRoles_id()!=0 && Form.isPost(req)  ){

            long id = Form.getLong(req, "id");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int roles_Id = Form.getInt(req, "roles_id");
            Roleparam user = new Roleparam(id, login, password, email, roles_Id);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
            }
            if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
            }

        }
        req.setAttribute("roles", dao.role.getALL());
        req.setAttribute("users", dao.user.getALL());
        return null;
    }

}
