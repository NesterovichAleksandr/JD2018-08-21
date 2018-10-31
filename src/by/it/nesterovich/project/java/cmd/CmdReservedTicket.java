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

public class CmdReservedTicket extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isGet(req)) {
            Dao dao = Dao.getDao();
            //String sql = "SELECT reserved_tickets.code, reserved_tickets.cost, reserved_tickets.users_id, films.name, cinemas.name
            // FROM reserved_tickets JOIN films ON reserved_tickets.films_id=films.id JOIN cinemas ON reserved_tickets.cinemas_id=cinemas.id;";
            List<ReservedTicket> reservedTickets = dao.reservedTicket.getAll(" WHERE `users_id`=" + Utils.getUser(req).getId());
            List<Film> films = dao.film.getAll("");
            List<Cinema> cinemas = dao.cinema.getAll("");
            if (reservedTickets.size() > 0) {
                req.setAttribute("reservedTickets", reservedTickets);
                req.setAttribute("films", films);
                req.setAttribute("cinemas", cinemas);
            }
        }
        return null;
    }
}
