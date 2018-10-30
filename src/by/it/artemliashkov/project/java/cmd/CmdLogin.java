package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.Actions;
import by.it.artemliashkov.project.java.beans.Agent;
import by.it.artemliashkov.project.java.dao.Dao;
import by.it.artemliashkov.project.java.utils.Form;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        if (Form.isPost(req)) {

            String name = req.getParameter("name");
            String address = req.getParameter("address");
            Dao dao = Dao.getDAO();
            String where = String.format(" WHERE name='%s' AND address='%s'", name, address);
            List<Agent> agents = dao.agent.getAll(where);
            if (agents.size() > 0) {
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(30);
                session.setAttribute("agent", agents.get(0));
                Cookie cookieName = new Cookie("name", name);
                Cookie cookieAddress = new Cookie("address", address);
                cookieName.setMaxAge(60);
                cookieAddress.setMaxAge(60);
                resp.addCookie(cookieName);
                resp.addCookie(cookieAddress);
                return Actions.USERCABINET.cmd;
            } else {
                req.setAttribute("agent", "no agent: " + name + " or incorrect address");
            }
        }
        return null;
    }
}
