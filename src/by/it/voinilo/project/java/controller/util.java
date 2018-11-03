package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Roleparam;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class util {
    static Roleparam getUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (Roleparam) oUser;
            }

        }
        return null;
    }

    public static void saveImage(HttpServletRequest req, String filename) throws IOException, ServletException {
        String path = req.getServletContext().getRealPath("/images") + File.separator + filename;
        Part part = req.getPart("upload");

        try (

             InputStream in = part.getInputStream();
             FileOutputStream out = new FileOutputStream(path);){
            byte [] buf = new byte[100000];
            int lenght = in.read(buf);
            out.write(buf,0,lenght);
        }
    }
}