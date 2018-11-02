package by.it.korzik.project.java.controller;

import by.it.korzik.project.java.dao.beans.Orders;
import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdCreateOrder extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Users user = Util.getUser(req);
        Util.updateAll(req);
        if (user==null){
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)){
            long menu = Form.getLong(req,"menu_id");
            DAO dao = DAO.getDAO();
            Orders orders = new Orders(0, user.getId(), menu);
            dao.order.create(orders);
            req.setAttribute("complete","Order created");
        }
        return null;
    }
}
