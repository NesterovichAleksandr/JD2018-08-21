package by.it.kisielev.project5.java;

import by.it.kisielev.project5.java.dao.Dao;
import by.it.kisielev.project5.java.beans.Compani;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("compani","hello");
        if (req.getMethod().equalsIgnoreCase("post")) {
            req.setAttribute("compani","hello2");
            String login =req.getParameter("login");
            String password=req.getParameter("password");
            Dao dao=Dao.getDao();
            String where= String.format(" WHERE Login='%s' AND PASSWORD='%s'",login,password);
            List<Compani> companis= dao.compani.getAll(where);
            if (companis.size()>0){
                req.setAttribute("user", companis.get(0));
            }
        }

        return null;
    }

    public static void main(String[] args) throws SQLException {
        String where= String.format(" WHERE Login='%s' AND PASSWORD='%s'","testLogin","testPassword");
        List<Compani> all= Dao.getDao().compani.getAll(where);
        System.out.println(all.get(0));

    }
}
