package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListResumes extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
            List<Resume> resumes = Dao.getDao().resume.getAll();
            if(resumes.size() > 0) {
                req.setAttribute("resumes", resumes);
            }

        return null;
    }
}
