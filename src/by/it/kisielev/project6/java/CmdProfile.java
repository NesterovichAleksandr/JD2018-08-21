package by.it.kisielev.project6.java;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdProfile extends  Cmd{
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if(From.isPost(req), req.getParameter("lodout")!=null){
            HttpServlet session=  req.getSession();
            session.inva
        }
        }
    }
}
