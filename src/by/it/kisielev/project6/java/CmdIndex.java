package by.it.kisielev.project6.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
    {
        req.setAttribute("ads", nlnlknl);
    return null;
    }
}
