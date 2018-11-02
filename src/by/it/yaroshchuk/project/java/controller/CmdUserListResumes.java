package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdUserListResumes extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);
        Dao dao = Dao.getDao();
        if(user==null)
            return Action.LOGIN.cmd;
        if(Form.isPost(req)){
            String fullname = Form.getString(req, "fullName");
            String dob = Form.getString(req, "dob");
            String country = Form.getString(req, "country");
            String city = Form.getString(req, "city");
            String education = Form.getString(req, "education");
            String degree = Form.getString(req, "degree");
            Integer graduateYear = Form.getInt(req, "graduateYear");
            String experience = Form.getString(req, "experience");
            String post = Form.getString(req, "post");
            Integer worktime = Form.getInt(req, "worktime");
            Resume resume = new Resume(0, fullname, dob, country, city, education, degree, graduateYear,
                    experience, post, worktime, user.getId());
            if(req.getParameter("Update") != null)
                dao.resume.update(resume);
            if(req.getParameter("Delete") != null)
                dao.resume.delete(resume);
        }
        List<Resume> resumes = dao.resume.getAll(" WHERE `resumes`.`users_id`=" + user.getId());
        HttpSession session = req.getSession();
        session.setAttribute("resumes", resumes);
        return null;
    }
}
