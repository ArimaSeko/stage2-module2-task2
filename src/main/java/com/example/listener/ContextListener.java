package com.example.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        LocalDateTime initTime = LocalDateTime.now(); // Get the current time

        // Set the "servletTimeInit" attribute in the context
        context.setAttribute("servletTimeInit", initTime);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
