package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class CmdProfile extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req) && req.getParameter("logout") != null) {
            resp.addCookie(new Cookie("password", ""));
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.LOGIN.cmd;
        }
        Dao dao = Dao.getDao();
        req.setAttribute("login", user.getLogin());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("tickets", dao.ticket.getAll(" WHERE `users_id`=" + user.getId()));
        req.setAttribute("users", dao.user.getAll());
        req.setAttribute("routes", dao.route.getAll());
        return null;
    }
}
