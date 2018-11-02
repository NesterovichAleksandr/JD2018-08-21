package by.it.yaroshchuk.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp){
        if(Util.getUser(req) != null){
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
