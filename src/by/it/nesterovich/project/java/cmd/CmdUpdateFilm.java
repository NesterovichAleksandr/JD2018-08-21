package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.Film;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Patterns;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdUpdateFilm extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)) {
            Long filmId = Long.valueOf(req.getParameter("filmId"));
            String name = Form.getString(req.getParameter("filmName"), Patterns.NAMEFILM);
            String country = Form.getString(req.getParameter("filmCountry"), Patterns.COUNTRY);
            String genre = Form.getString(req.getParameter("filmGenre"), Patterns.GENRE);
            int yearOfIssue = Integer.parseInt(Form.getString(req.getParameter("filmYearOfIssue"), Patterns.YEAROFISSUE));
            int duration = Integer.parseInt(Form.getString(req.getParameter("filmDuration"), Patterns.DURATION));
            Film film = new Film(filmId, name, country, genre, yearOfIssue, duration);
            Dao.getDao().film.update(film);
            return Action.LISTFILM.cmd;
        }
        return null;
    }
}
