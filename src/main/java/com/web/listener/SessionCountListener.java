package com.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext application = se.getSession().getServletContext();
        if(application.getAttribute("count") == null) {
            application.setAttribute("count", 0);
        }
        int count = Integer.parseInt(application.getAttribute("count").toString());
        count++;
        application.setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext application = se.getSession().getServletContext();
        if(application.getAttribute("count") == null) {
            return;
        }
        int count = Integer.parseInt(application.getAttribute("count").toString());
        count--;
        application.setAttribute("count", count);
    }
    
}
