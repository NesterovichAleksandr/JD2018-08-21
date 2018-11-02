package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdAdmin extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        User user = Util.getUser(req);
        if (user == null || (!user.getLogin().equals("admin") && !user.getPassword().equals("admin"))) {
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
