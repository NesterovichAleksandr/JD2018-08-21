package by.it.litvin.project.java.controller;
import by.it.litvin.project.java.dao.Dao;
import by.it.litvin.project.java.dao.beans.Form;
import by.it.litvin.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

    public class CmdCreateForm extends Cmd {
        @Override
        public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
            if (Util.getUser(req) == null)
                return Action.LOGIN.cmd;
            if (Forms.isPost(req)) {
                User user = Util.getUser(req);
                String name = Forms.getString(req, "name");
                String surname = Forms.getString(req, "surname");
                String address = Forms.getString(req, "address");
                String description = Forms.getString(req, "description");
                int age = Forms.getInt(req, "age");
                String information = Forms.getString(req, "information");
                String aim = Forms.getString(req, "aim");
                Form form = new Form(0, name, surname, address, description, age,
                        information, aim, user.getId());
                Dao.getDao().form.create(form);
                return Action.PROFILE.cmd;
            }
            return null;
        }
    }

