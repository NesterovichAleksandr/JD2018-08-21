package by.it.korolchuk.project.java.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private ActionResolver actionResolver;

    @Override
    public void init() throws ServletException {
        actionResolver = new ActionResolver();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       //resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        process(req, resp) ;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        process(req, resp);
    }

    private void process (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Action action = actionResolver.resolve(req);
        Cmd command = action.cmd;
        Cmd nextCommand;
        String view = action.getJsp();

        try {
            nextCommand = command.execute(req, resp);
        } catch (Exception e) {
            nextCommand = null;
            view = Action.ERROR.getJsp();
            req.setAttribute("printStackTrace", e.toString());
        }
        if (nextCommand == null || nextCommand == command) {
            getServletContext().getRequestDispatcher(view).forward(req,resp);
    } else
        resp.sendRedirect("do?command=" + nextCommand.toString());
    }

}
