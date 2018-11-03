package by.it.galushka.project.java.filters;


import javax.servlet.*;
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
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String[] split = req.getRequestURI().split("/");
        String fileName = split[split.length - 1];
        String path = req.getServletContext().getRealPath("/img") + File.separator + fileName;
        if (new File(path).exists()) {
            filterChain.doFilter(req, resp);
        } else {
            req.getRequestDispatcher("/img/noimage.png").forward(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
