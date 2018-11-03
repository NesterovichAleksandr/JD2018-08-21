package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Company;
import by.it.yaroshchuk.project.java.beans.Request;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdEditCompanies extends Cmd {
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
            long companyId = Form.getLong(req, "companyId");
            String companyName = Form.getString(req, "name");
            String companyStartYear = Form.getString(req, "startYear");
            String companyAbout = Form.getString(req, "about");
            Company company = new Company(companyId, companyName, companyStartYear, companyAbout, id);
            if(req.getParameter("Update") != null) {
                dao.user.update(user);
                dao.company.update(company);
            }
            if(req.getParameter("Delete") != null) {
                List<Request> requests = dao.request.getAll("WHERE `requests`.`companies_id`=" + company.getId());
                for (Request request : requests) {
                    dao.request.delete(request);
                }
                dao.company.delete(company);
                dao.user.delete(user);
            }
        }
        req.setAttribute("companies", dao.company.getAll());
        req.setAttribute("users", dao.user.getAll());

        return null;
    }
}
