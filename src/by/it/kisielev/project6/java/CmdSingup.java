package by.it.kisielev.project6.java;

import by.it.kisielev.project6.java.Action;
import by.it.kisielev.project6.java.Cmd;
import by.it.kisielev.project6.java.beans.Compani;
import by.it.kisielev.project6.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdSingup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("post")){
            String login=req.getParameter("login");
            String password=req.getParameter("password");
            Compani compani=new Compani(0, Ту-214, 1000, qwerty,78,2 );
            Dao dao= Dao.getDao();
            dao.compani.create(compani);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
