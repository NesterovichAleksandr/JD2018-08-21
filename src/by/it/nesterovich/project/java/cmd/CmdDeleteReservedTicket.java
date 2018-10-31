package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdDeleteReservedTicket extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
