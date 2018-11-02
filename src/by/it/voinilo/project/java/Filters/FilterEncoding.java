package by.it.voinilo.project.java.Filters;

import javax.servlet.*;
import java.io.IOException;

public class FilterEncoding implements Filter {

    String encode;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
        System.out.println("Filter init= "+encode);
    }

    @Override
    public void doFilter(ServletRequest Req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String charachterEncoding = Req.getCharacterEncoding();
        if (charachterEncoding==null || !charachterEncoding.equalsIgnoreCase(encode))
            Req.setCharacterEncoding(encode);

        charachterEncoding = resp.getCharacterEncoding();
        if (charachterEncoding==null || !charachterEncoding.equalsIgnoreCase(encode))
            resp.setCharacterEncoding(encode);
        filterChain.doFilter(Req, resp);
    }

    @Override
    public void destroy() {

    }
}

