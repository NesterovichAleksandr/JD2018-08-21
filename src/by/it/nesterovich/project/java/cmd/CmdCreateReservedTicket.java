package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.ReservedTicket;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdCreateReservedTicket extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req,resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();

        if (Form.isPost(req)) {
            if (req.getParameter("reservButton") != null) {
                long idFilm = (long) session.getAttribute("IdFilm");
                long idUser = user.getId();
                long idCinema =Form.getLong(req, "cinemaId");
                ReservedTicket reservedTicket = new ReservedTicket(
                        0,
                        11111111,
                        7.0,
                        idUser,
                        idFilm,
                        idCinema
                );
                dao.reservedTicket.create(reservedTicket);
                return Action.LISTRESERVEDTICKET.cmd;
            }
        }
        return null;
    }
}
