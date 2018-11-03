package by.it.kisielev.project6.java;


import by.it.kisielev.project6.java.beans.Compani;
import by.it.kisielev.project6.java.dao.Form;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdCreateAd extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpServlet session=req.getSession(false);
        if(session==null)
            return Action.LOGIN.cmd;
        Compani compani=
        if (Form.isPost(req))
            String description=Form.get
        return null;
    }
}
