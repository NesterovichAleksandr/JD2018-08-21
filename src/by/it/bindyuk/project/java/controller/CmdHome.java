package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdHome extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getCookies().length > 1) {
            String loginCok = "login";
            String passCok = "password";
            String login;

            Cookie[] cookies = req.getCookies();
            User user = null;
            for (Cookie myCookie : cookies) {
                if (loginCok.equals(myCookie.getName())) {
                    login = myCookie.getValue();
                    String where = " WHERE login='" + login + "'";
                    List<User> users = Dao.getDao().user.getAll(where);
                    user = users.get(0);
                }
            }
            for (Cookie myCookie : cookies) {
                if (passCok.equals(myCookie.getName())) {
                    assert user != null;
                    if (DigestUtils.md5Hex(user.getPassword()).equals(myCookie.getValue())) {  //сравниваем пароль из
                        HttpSession session = req.getSession();                                // кук с хэшированным
                        session.setAttribute("user", user);                                 // этим же алгоритмом паролемиз бд
                        return Action.PROFILE.cmd;
                    }
                }
            }
        }
        return null;
    }
}
