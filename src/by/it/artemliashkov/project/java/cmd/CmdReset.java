package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.Actions;
import by.it.artemliashkov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdReset extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Dao.getDAO().reset();
        return Actions.SIGNUP.cmd;
    }

}