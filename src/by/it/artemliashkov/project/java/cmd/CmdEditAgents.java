package by.it.artemliashkov.project.java.cmd;


import by.it.artemliashkov.project.java.beans.Agent;
import by.it.artemliashkov.project.java.dao.Dao;
import by.it.artemliashkov.project.java.utils.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdEditAgents extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Dao dao = Dao.getDAO();
        if (Form.isPost(req)) {
            long id = Form.getLong(req, "id");
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            Agent agent = new Agent(id, name, address, 1);
            if (req.getParameter("Update") != null) {
                dao.agent.update(agent);
            }
        }
        req.setAttribute("agents", dao.agent.getAll(""));
        return null;
    }
}
