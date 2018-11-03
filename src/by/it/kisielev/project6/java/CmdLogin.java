package by.it.kisielev.project6.java;

import by.it.kisielev.project6.java.beans.Compani;
import by.it.kisielev.project6.java.dao.Dao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {

            String login =req.getParameter("login");
            String password=req.getParameter("password");
            Dao dao= Dao.getDao();
            String where= String.format(" WHERE Login='%s' AND PASSWORD='%s'",login,password);
            List<Compani> companis= dao.companis.getAll(where);
            if (companis.size()>0){
                HttpServlet session=req.getSession();
                session.setAttribute("user", companis.get(0));
                return Action.PROFILE.cmd;
            }
        }

        return null;
    }

    public static void main(String[] args) throws SQLException {
        String where= String.format(" WHERE Login='%s' AND PASSWORD='%s'","testLogin","testPassword");
        List<Compani> all= Dao.getDao().companis.getAll(where);
        System.out.println(all.get(0));

    }
}
