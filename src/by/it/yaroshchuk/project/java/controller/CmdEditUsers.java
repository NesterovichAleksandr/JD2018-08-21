package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Request;
import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdEditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User admin = Util.getUser(req);
        Dao dao = Dao.getDao();
        if(admin==null)
            return Action.LOGIN.cmd;
        if(Form.isPost(req)){
            long id = Form.getLong(req, "id");
            String login = Form.getString(req, "login");
            String email = Form.getString(req, "email");
            String password = Form.getString(req, "password");
            long rolesId = Form.getLong(req, "rolesId");
            User user = new User(id, login, password, email, rolesId);
            if(req.getParameter("Update") != null)
                dao.user.update(user);
            if(req.getParameter("Delete") != null) {
                List<Resume> resumes = dao.resume.getAll("WHERE `resumes`.`users_id`=" + user.getId());
                for (Resume resume : resumes) {
                    List<Request> requests = dao.request.getAll("WHERE `requests`.`resumes_id`=" + resume.getId());
                    for (Request request : requests) {
                        dao.request.delete(request);
                    }
                    dao.resume.delete(resume);
                }
                dao.user.delete(user);
            }
        }
        req.setAttribute("roles", dao.role.getAll());
        req.setAttribute("users", dao.user.getAll());
        return null;
    }
}
