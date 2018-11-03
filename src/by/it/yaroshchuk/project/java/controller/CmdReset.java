package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdReset extends  Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) {
        Dao.getDao().reset();
        return Action.RESET.cmd;
    }
}
