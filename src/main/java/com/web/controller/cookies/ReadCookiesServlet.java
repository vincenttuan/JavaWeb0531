package com.web.controller.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/cookies/read")
public class ReadCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                out.println(cookie.getName() + " : " + cookie.getValue());
            }
        } else {
            out.print("No cookie !");
        }
        
    }
        
}
