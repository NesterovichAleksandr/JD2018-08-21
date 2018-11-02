package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.Cinema;
import by.it.nesterovich.project.java.beans.FilmCinema;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdListCinema extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();

        List<Cinema> cinemas = dao.cinema.getAll("");
        if (cinemas.size() > 0) {
            req.setAttribute("cinemas", cinemas);
        }
        long idFilm = (long) session.getAttribute("IdFilm");
        String formatFilmCinema = String.format(" WHERE films_cinemas.films_id=%d", idFilm);
        List<FilmCinema> listCinemasForFilm = dao.filmCinema.getAll(formatFilmCinema);
        if (listCinemasForFilm.size() > 0) {
            req.setAttribute("listCinemaForFilm", listCinemasForFilm);
        }
        return null;
    }
}
