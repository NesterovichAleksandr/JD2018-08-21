package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdCreateResume extends  Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Util.getUser(req) == null)
            return Action.LOGIN.cmd;
        if (Form.isPost(req)) {
            User user = Util.getUser(req);
            if(user != null) {
                String resumeName = Form.getString(req, "resumeName");
                String fullname = Form.getString(req, "fullname");
                String dob = Form.getString(req, "dob");
                String country = Form.getString(req, "country");
                String city = Form.getString(req, "city");
                String education = Form.getString(req, "education");
                String degree = Form.getString(req, "degree");
                Integer graduateYear = Form.getInt(req, "graduateYear");
                String experience = Form.getString(req, "experience");
                String post = Form.getString(req, "post");
                String about = Form.getString(req, "about");
                Integer worktime = Form.getInt(req, "worktime");
                Resume resume = new Resume(0, resumeName, fullname, dob, country, city, education, degree, graduateYear,
                        experience, post, worktime, about, user.getId());
                Dao.getDao().resume.create(resume);
                return Action.USERLISTRESUMES.cmd;
            }
        }
        return null;
    }
}
