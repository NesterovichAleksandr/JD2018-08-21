package by.it.bindyuk.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdError extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    static void setAttr(HttpServletRequest req, String s) {
        req.setAttribute("printStackTrace", s);
    }
}
