package by.it.akhmelev.project8.java.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class FilterImage implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String[] part = req.getRequestURI().split("/");
        String filename = part[part.length - 1];
        String path = req.getServletContext().getRealPath("/image") + File.separator + filename;
        if (new File(path).exists()){
            filterChain.doFilter(req,res);
        }
        else
            req.getRequestDispatcher("/image/noimage.png").forward(req,res);

    }

    @Override
    public void destroy() {

    }
}
