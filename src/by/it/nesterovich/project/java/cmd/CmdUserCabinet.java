package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdUserCabinet extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req) && req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            Cookie[] cookies = req.getCookies();
            if (cookies.length > 0) {
                for (int i = 0; i < cookies.length; i++) {
                    if ("login".equals(cookies[i].getName())) {
                        resp.addCookie(new Cookie("login", ""));
                    }
                    if ("password".equals(cookies[i].getName())) {
                        resp.addCookie(new Cookie("password", ""));
                    }
                }
            }
            return Action.INDEX.cmd;
        }
        return null;
    }
}
