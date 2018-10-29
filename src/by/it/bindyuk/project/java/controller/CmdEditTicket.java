package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.Route;
import by.it.bindyuk.project.java.dao.beans.Ticket;
import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

 class CmdEditTicket extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);

        if (Form.isPost(req) && req.getParameter("confirm") != null) {
            List<Route> routes = Dao.getDao().route.getAll();
            assert user != null;
            List<Ticket> all = Dao.getDao().ticket.getAll(" WHERE `tickets`.`users_id`=" + user.getId());
            Ticket ticket = all.get(0);
            String transport = Form.getString(req, "transport");
            if (transport == null || transport.equalsIgnoreCase("")) {
                transport = ticket.getTransport();
            }

            //==========================================================================================================
            String from = req.getParameter("from");
            long idFrom = 0;
            for (Route route : routes) {
                if (route.getCity().equalsIgnoreCase(from)) {
                    idFrom = route.getId();
                }
            }
            if (from == null || from.equalsIgnoreCase("")) {
                idFrom = ticket.getRoutesIdFrom();
            }

            //==========================================================================================================
            String to = req.getParameter("to");
            long idTo = 0;
            for (Route route : routes) {
                if (route.getCity().equalsIgnoreCase(to)) {
                    idTo = route.getId();
                }
            }
            if (to == null || to.equalsIgnoreCase("")) {
                idTo = ticket.getRoutesIdTo();
            }

            Timestamp when = Timestamp.valueOf(req.getParameter("date"));
            if (when.toString().equalsIgnoreCase("")) {
                when = ticket.getData();
            }
            ticket.setTransport(transport);
            ticket.setRoutesIdFrom(idFrom);
            ticket.setRoutesIdTo(idTo);
            ticket.setData(when);
            Dao.getDao().ticket.update(ticket);
            return Action.PROFILE.cmd;
        }
        return null;
    }
}
