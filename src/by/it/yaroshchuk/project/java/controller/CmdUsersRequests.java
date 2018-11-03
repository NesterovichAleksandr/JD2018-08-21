package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdUsersRequests extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);
        Dao dao = Dao.getDao();
        if(user==null)
            return Action.LOGIN.cmd;

        List<Resume> resumes = dao.resume.getAll(" WHERE `resumes`.`users_id`=" + user.getId());
        HttpSession session = req.getSession();
        session.setAttribute("resumes", resumes);
        session.setAttribute("requests", dao.request.getAll());
        session.setAttribute("companies", dao.company.getAll());
        return null;
    }
}
