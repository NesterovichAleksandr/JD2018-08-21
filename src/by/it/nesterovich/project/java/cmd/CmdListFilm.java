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
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();

        List<Film> films = dao.film.getAll("");
        if (films.size() > 0) {
            req.setAttribute("films", films);
        }
        List<Cinema> cinemas = dao.cinema.getAll("");
        if (cinemas.size() > 0) {
            req.setAttribute("cinemas", cinemas);
        }
        if (Form.isPost(req)) {
            if (req.getParameter("listCinemaButton") != null) {
                session.setAttribute("IdFilm", Form.getLong(req, "filmId"));
                return Action.LISTCINEMA.cmd;
            }
        }
        return null;
    }
}
