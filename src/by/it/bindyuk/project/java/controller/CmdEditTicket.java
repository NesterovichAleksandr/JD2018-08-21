package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.Ticket;
import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

class CmdEditTicket extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Dao dao = Dao.getDao();
        User admin = Util.getUser(req);
        if (admin == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)) {
            long id = Long.valueOf(Form.getString(req, "id"));
            String transport = Form.getString(req, "transport");
            long routesIdFrom = Long.valueOf(Form.getString(req, "routesIdFrom"));
            long routesIdTo = Long.valueOf(Form.getString(req, "routesIdTo"));
            Timestamp data = Timestamp.valueOf(Form.getString(req, "data"));
            long users_id = Long.valueOf(req.getParameter("usersId"));

            Ticket ticket = new Ticket(id, transport, routesIdFrom, routesIdTo, data, users_id);
            if (req.getParameter("Update") != null) {
                dao.ticket.update(ticket);
            }
            if (req.getParameter("Delete") != null) {
                dao.ticket.delete(ticket);
            }
        }
        req.setAttribute("tickets", dao.ticket.getAll());
        req.setAttribute("users", dao.user.getAll());
        return null;
    }
}
