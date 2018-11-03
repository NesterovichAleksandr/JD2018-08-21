package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.ReservedTicket;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdDeleteReservedTicket extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req,resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)) {
            if (req.getParameter("deleteButton") != null) {
                long id = Form.getLong(req, "idReservedTicket");
                ReservedTicket reservedTicket = new ReservedTicket(
                        id,
                        11111111,
                        1.0,
                        1,
                        1,
                        1
                );
                Dao.getDao().reservedTicket.delete(reservedTicket);
                return Action.LISTRESERVEDTICKET.cmd;
            }
        }
        return null;
    }
}
