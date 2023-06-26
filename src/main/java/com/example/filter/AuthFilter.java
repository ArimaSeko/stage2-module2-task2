package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {
        "/user/*"
})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String username = filterConfig.getInitParameter("username");
        String password = filterConfig.getInitParameter("password");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("on filter");
        RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/login.jsp");
        if(servletRequest.getAttribute("user")!=null)filterChain.doFilter(servletRequest, servletResponse);
        else dispatcher.forward(servletRequest,servletResponse);
    }
}