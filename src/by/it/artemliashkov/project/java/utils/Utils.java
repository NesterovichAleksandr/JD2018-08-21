package by.it.artemliashkov.project.java.utils;

import by.it.artemliashkov.project.java.beans.Agent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {

    public static Agent getAgent(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oAgent = session.getAttribute("agent");
            if (oAgent != null) {
                return (Agent) oAgent;
            }
        }
        return null;
    }
}
