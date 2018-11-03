package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.Actions;
import by.it.artemliashkov.project.java.beans.Agent;
import by.it.artemliashkov.project.java.dao.Dao;
import by.it.artemliashkov.project.java.utils.Form;
import by.it.artemliashkov.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdUserCabinet extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Agent agent = Utils.getAgent(req);
        if (agent == null) {
            return Actions.LOGIN.cmd;
        }
        if (Form.isPost(req)) {
            if (req.getParameter("update") != null) {
                agent.setName(req.getParameter("name"));
                agent.setAddress(req.getParameter("address"));
                Dao.getDAO().agent.update(agent);
            } else if (req.getParameter("logout") != null) {

                HttpSession session = req.getSession();
                session.invalidate();
                return Actions.LOGIN.cmd;
            }
        }
        return null;
    }
}
