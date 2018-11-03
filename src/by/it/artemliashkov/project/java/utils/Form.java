package by.it.artemliashkov.project.java.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {

    public static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }

    public static boolean isGet(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("get");
    }

    public static String getString(HttpServletRequest request, String name)  throws ParseException {
        return getString(request, name, ".*");
    }

    public static String getString(HttpServletRequest request, String name, String pattern) throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches(pattern))
            return value;
        throw new ParseException("Field "+name+" incorrect. ",0);
    }

    public static Integer getInt(HttpServletRequest request, String name)  throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches("[-0-9]+"))
            return Integer.valueOf(value);
        throw new ParseException("Field "+name+" incorrect. ",0);

    }

    public static Long getLong(HttpServletRequest request, String name)  throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches("[-0-9]+"))
            return Long.valueOf(value);
        throw new ParseException("Field "+name+" incorrect. ",0);

    }

    public static Double getDouble(HttpServletRequest request, String name)  throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches("[-0-9.]+"))
            return Double.valueOf(value);
        throw new ParseException("Field "+name+" incorrect. ",0);
    }
}