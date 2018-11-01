package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.*;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdListFilm extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        User user = Utils.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        HttpSession session = req.getSession();
        Dao dao = Dao.getDao();

        List<Film> films = dao.film.getAll("");
        if (films.size() > 0) {
            session.setAttribute("films", films);
            //req.setAttribute("films", films);
        }

        List<Cinema> cinemas = dao.cinema.getAll("");
        if (cinemas.size() > 0) {
            session.setAttribute("cinemas", cinemas);
            //req.setAttribute("cinemas", cinemas);
        }

        //List<FilmCinema> listCinemasForFilm = dao.filmCinema.getAll(String.format(" WHERE films_cinemas.films_id=%d", Form.getLong(req, "filmId")));
        List<FilmCinema> listCinemasForFilm = dao.filmCinema.getAll(String.format(" WHERE films_cinemas.films_id=%d", 1));
        if (listCinemasForFilm.size() > 0) {
            session.setAttribute("listCinemaForFilm", listCinemasForFilm);
            //req.setAttribute("listCinemaForFilm", listCinemasForFilm);
        }
        if (Form.isPost(req)) {

            if (req.getParameter("reservButton") != null) {
                //бронь создаётся с конкретными числами. проверено.
                ReservedTicket reservedTicket = new ReservedTicket(
                        0,
                        11111111,
                        7.0,
                        2,//user.getId(),
                        1,//Form.getLong(req, "filmId"),//req.getParameter("filmId"),
                        2//Form.getLong(req, "cinemaId") //req.getParameter("cinemaId")
                );
                dao.reservedTicket.create(reservedTicket);
                return Action.USERCABINET.cmd;
            }
        }
        return null;
    }
}
