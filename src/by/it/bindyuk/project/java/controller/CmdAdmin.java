package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 class CmdAdmin extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp){

        User user = Util.getUser(req);
        if (user == null || (!user.getLogin().equals("admin") && !user.getPassword().equals("admin"))) {
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
