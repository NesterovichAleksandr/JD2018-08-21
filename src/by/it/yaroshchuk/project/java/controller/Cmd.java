package by.it.yaroshchuk.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Cmd {

    Cmd execute(HttpServletRequest req, HttpServletResponse resp);
}
