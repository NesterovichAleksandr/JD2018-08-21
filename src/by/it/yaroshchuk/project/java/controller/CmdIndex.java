package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.Company;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Company> companies = Dao.getDao().company.getAll();
        if(Form.isPost(req)) {
            String str = req.getParameter("searchinput");
            System.out.println(str);
        }
        req.setAttribute("companies", companies);
        return null;
    }
}
