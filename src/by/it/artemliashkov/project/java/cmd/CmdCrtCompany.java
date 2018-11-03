package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.Actions;
import by.it.artemliashkov.project.java.beans.Company;
import by.it.artemliashkov.project.java.dao.Dao;
import by.it.artemliashkov.project.java.utils.Form;
import by.it.artemliashkov.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdCrtCompany extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        if (Utils.getAgent(req) == null)
            return Actions.LOGIN.cmd;
        if (Form.isPost(req)) {
            String name = Form.getString(req,"name");
            String type = Form.getString(req,"type");
            int amount_agents = Form.getInt(req,"amount_agents");
            String address = Form.getString(req,"address");
            Company company = new Company(0, name, type, amount_agents, address,1);
            Dao dao = Dao.getDAO();
            dao.company.create(company);
            return Actions.LISTCOMPANY.cmd;
        }
        return null;
    }
}