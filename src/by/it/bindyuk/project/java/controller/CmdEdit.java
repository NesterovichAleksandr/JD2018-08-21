package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.Ticket;
import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CmdEdit extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        User user = Util.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req) && req.getParameter("edit") != null) {
            List<Ticket> all = Dao.getDao().ticket.getAll(" WHERE `tickets`.`users_id`=" + user.getId());
            if (all.size() > 0) {
                return Action.EDITTICKET.cmd;
            }
        }
        return null;
    }
}
