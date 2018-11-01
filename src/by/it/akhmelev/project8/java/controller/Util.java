package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
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

    static void saveImage(HttpServletRequest req, String filename) throws IOException, ServletException {
        Part part = req.getPart("upload");
        String path = req.getServletContext().getRealPath("/image") + File.separator + filename;
        File img = new File(path);
        try (
                InputStream in = part.getInputStream();
                FileOutputStream out = new FileOutputStream(img)
        ) {
            while (in.available() > 0) { //для больших файлов за один раз не получится
                byte[] buf = new byte[100000];
                int len = in.read(buf);
                out.write(buf, 0, len);
            }
        }
        //если файл нулевого размера то удалим его
        if (img.exists() && img.length() > 0 && img.delete())
            System.out.println(path + " deleted...");
    }
}


