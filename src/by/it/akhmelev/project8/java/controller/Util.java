package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Util {

    static User getUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (User) oUser;

            }
        }
        return null;
    }

    public static void saveImage(HttpServletRequest req, String filename) throws IOException, ServletException {
        Part part = req.getPart("upload");
        String path = req.getServletContext().getRealPath("/image") + File.separator + filename;
        try (
        InputStream in = part.getInputStream();
        FileOutputStream out=new FileOutputStream(path)
        ){
            byte[] buf=new byte[100000];
            int len = in.read(buf);
            out.write(buf,0,len);
        }


    }
}


