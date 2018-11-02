package by.it.yaroshchuk.project.java.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterEncoding implements Filter {

    String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
        System.out.println("Filter init. encode = " + encode);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String characterEncoding = servletRequest.getCharacterEncoding();
        if(characterEncoding == null || !characterEncoding.equalsIgnoreCase(encode)) {
            servletRequest.setCharacterEncoding(encode);
        }

        characterEncoding = servletResponse.getCharacterEncoding();
        if(characterEncoding == null || !characterEncoding.equalsIgnoreCase(encode)) {
            servletResponse.setCharacterEncoding(encode);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
