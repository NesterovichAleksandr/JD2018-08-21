package by.it.kisielev.project5.java;

import by.it.kisielev.project5.java.beans.Compani;
import by.it.kisielev.project5.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdSingup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("post")){
            String login=req.getParameter("login");
            String password=req.getParameter("password");
            Compani compani=new Compani(0,login,password,0 );
            Dao dao= Dao.getDao();
            dao.compani.create(compani);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
