package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/CalcArea") // url-pattern
public class CalcAreaServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().print("Sorry~~");
//    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string_r = req.getParameter("r");
        int r = Integer.parseInt(string_r);
        double area = Math.pow(r, 2) * Math.PI;
        resp.getWriter().print(String.format("r: %d area: %.2f", r, area));
    }
    
}
