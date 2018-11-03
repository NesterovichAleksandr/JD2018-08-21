package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Request;
import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdEditResumes extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User admin = Util.getUser(req);
        Dao dao = Dao.getDao();
        if(admin==null)
            return Action.LOGIN.cmd;
        if(Form.isPost(req)){
            String resumeid = Form.getString(req, "id");
            List<Resume> resumes = dao.resume.getAll("WHERE `resumes`.`id`=" + resumeid);

            if(req.getParameter("Delete") != null) {
                if(resumes.size() > 0) {
                    List<Request> requests = dao.request.getAll("WHERE `requests`.`resumes_id`=" + resumes.get(0).getId());
                    for (Request request : requests) {
                        dao.request.delete(request);
                    }
                    dao.resume.delete(resumes.get(0));
                }
            }
        }
        req.setAttribute("resumes", dao.resume.getAll());
        //req.setAttribute("users", dao.user.getAll());
        return null;
    }
}
