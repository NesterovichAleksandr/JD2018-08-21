package by.it.artemliashkov.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionResolver {

    Actions resovler(HttpServletRequest req) {
        Actions result = Actions.ERROR;

        String command = req.getParameter("command");
        if (command == null) return Actions.INDEX;

        try {
            Actions action = Actions.valueOf(command.toUpperCase());
            req.getServletContext().log("RESOLVE:" + action.cmd.toString());
            result = Actions.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            //result = Action.ERROR;
            //message to error.jsp
        }
        return result;
    }
}
