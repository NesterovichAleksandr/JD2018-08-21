package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Menu;
import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdCreateMenu extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Users user = Util.getUser(req);
        if (user==null){
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)){
            String name = Form.getString(req,"name");
            String ingridients = Form.getString(req,"ingridients");
            double weight = Form.getDouble(req,"weight");
            double price = Form.getDouble(req,"price");
            DAO dao = DAO.getDAO();
            Menu menu = new Menu(0, name, ingridients, weight, price);
            dao.menu.create(menu);
        }
        return null;
    }
}
