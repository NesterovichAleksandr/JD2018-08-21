package by.it.yaroshchuk.project.java.controller;

import by.it.yaroshchuk.project.java.beans.DetailRequestDto;
import by.it.yaroshchuk.project.java.beans.User;
import by.it.yaroshchuk.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdRequests extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User admin = Util.getUser(req);
        Dao dao = Dao.getDao();
        if(admin==null)
            return Action.LOGIN.cmd;
        List<DetailRequestDto> requests = DetailRequestDto.getRequestDto();
        if(requests.size() > 0) {
            req.setAttribute("requests", requests);
        }
        //req.setAttribute("users", dao.user.getAll());
        return null;
    }
}
