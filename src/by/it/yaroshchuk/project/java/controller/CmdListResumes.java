package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListResumes extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("IN CMD LIST RESUMES");
        if(req.getMethod().equalsIgnoreCase("post")) {
            System.out.println("LIST RESUMES - IF");
            Dao dao = Dao.getDao();
            List<Resume> resumes = dao.resume.getAll();
            if(resumes.size() > 0) {
                req.setAttribute("RESUMES: ", resumes);
            }
        }
        return null;
    }
}
