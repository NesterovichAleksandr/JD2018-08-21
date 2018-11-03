package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Roleparam;
import by.it.voinilo.project.java.entitydao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
  @Override

    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {


      if (Form.isPost(req)) {

          String login = req.getParameter("login");
          String password = req.getParameter("password");
          Dao dao = Dao.getDao();
          String where = String.format(" WHERE `login`='%s' AND `password`='%s'",login,password);
          List<Roleparam> users = dao.user.getALL(where);
          if (users.size()>0) {
              HttpSession session = req.getSession();
              session.setAttribute("user", users.get(0));
              session.setMaxInactiveInterval(90);
              return Action.PROFILE.cmd;
          }

      }
      return null;
  }



}
