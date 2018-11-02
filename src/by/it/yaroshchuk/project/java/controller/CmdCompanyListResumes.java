package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Company;
import by.it.yaroshchuk.project.java.beans.Request;
import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdCompanyListResumes extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);
        Dao dao = Dao.getDao();
        Company company;
        if(user!=null) {
            req.setAttribute("resumes", dao.resume.getAll());
            List<Company> companies = dao.company.getAll("WHERE `companies`.`users_id`=" + user.getId());

            if(companies.size() > 0) {
                company = companies.get(0);
                List<Request> requests =  dao.request.getAll("WHERE `requests`.`companies_id`=" + company.getId());
                if(requests.size() > 0)
                    req.setAttribute("requests", requests);
                else
                    req.setAttribute("requests", null);
            }

            if(req.getParameter("requestbtn") != null) {
                if(companies.size() > 0) {
                    company = companies.get(0);
                    long userId = Form.getLong(req, "usersId");
                    String message = Form.getString(req, "message");
                    Request request = new Request(0, message, company.getId(), userId);
                    System.out.println(request);
                    dao.request.create(request);
                }
                return Action.COMPANYLISTRESUMES.cmd;
            }
        }
        return null;
    }
}
