package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            try {
                String login = req.getParameter("login");
                String password = req.getParameter("password");
                Dao dao = Dao.getDao();

                if (req.getCookies().length > 0) {
                    int loginBuff = 0;
                    int passwordBuff = 0;
                    Cookie[] cookies = req.getCookies();
                    String loginCok = "login";
                    String passCok = "password";
                    for (int i = 0; i < cookies.length; i++) {
                        Cookie myCookie = cookies[i];
                        if (loginCok.equalsIgnoreCase(myCookie.getName())) {
                            if (login.equalsIgnoreCase(myCookie.getValue())) {
                                loginBuff = 1;
                            }
                        }
                        if (passCok.equalsIgnoreCase(myCookie.getName())) {
                            if (DigestUtils.md5Hex(password).equalsIgnoreCase(myCookie.getValue())) {
                                passwordBuff = 1;
                            }
                        }
                    }
                    if (loginBuff == 1 && passwordBuff == 1) {
                        String where = " WHERE login='" + login + "' AND password='" + password + "'";
                        List<User> users = dao.user.getAll(where);
                        HttpSession session = req.getSession();
                        session.setAttribute("user", users.get(0));
                        return Action.PROFILE.cmd;
                    }
                }

                String where = " WHERE login='" + login + "' AND password='" + password + "'";
                List<User> users = dao.user.getAll(where);


                if (users.size() > 0) {
                    HttpSession session = req.getSession();
                    session.setMaxInactiveInterval(30);                         //время жезни сессии без опроса страницы
                    Cookie loginCookie = new Cookie("login", login); //создаем куки и хэшируем пароль
                    Cookie passwordCookie = new Cookie("password", DigestUtils.md5Hex(password));
                    loginCookie.setMaxAge(60);
                    passwordCookie.setMaxAge(60); //время жизни куки
                    resp.addCookie(loginCookie);                                          //добавление куки в ответ
                    resp.addCookie(passwordCookie);
                    session.setAttribute("user", users.get(0));
                    return Action.PROFILE.cmd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
