package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.Cinema;
import by.it.nesterovich.project.java.beans.Film;
import by.it.nesterovich.project.java.beans.ReservedTicket;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListReservedTicket extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req,resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        Dao dao = Dao.getDao();
        List<ReservedTicket> reservedTickets = dao.reservedTicket.getAll(" WHERE `users_id`=" + Utils.getUser(req,resp).getId());
        List<Film> films = dao.film.getAll("");
        List<Cinema> cinemas = dao.cinema.getAll("");
        if (reservedTickets.size() > 0) {
            req.setAttribute("reservedTickets", reservedTickets);
            req.setAttribute("films", films);
            req.setAttribute("cinemas", cinemas);
        }
        if (Form.isPost(req)) {
            if (req.getParameter("Delete") != null) {

                dao.reservedTicket.delete(
                        new ReservedTicket(
                                Form.getLong(req, "id"),
                                111111,
                                1.0,
                                2,
                                2,
                                2
                        )
                );
                // req.setAttribute("reservedTickets", dao.reservedTicket.getAll(" WHERE `users_id`=" + Utils.getUser(req).getId()));
            }
        }
        return null;
    }
}
