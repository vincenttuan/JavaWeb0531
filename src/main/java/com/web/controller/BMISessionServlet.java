package com.web.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controller/bmi_session")
public class BMISessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession(true);
        //session.setMaxInactiveInterval(15);
        
        String cname  = req.getParameter("cname");
        Double height = Double.parseDouble(req.getParameter("height"));
        Double weight = Double.parseDouble(req.getParameter("weight"));
        Double bmi = weight / Math.pow(height/100.0, 2);
        
        // 將資料存入 session
        session.setAttribute("cname", cname);
        session.setAttribute("height", height);
        session.setAttribute("weight", weight);
        session.setAttribute("bmi", bmi);
        
        PrintWriter out = resp.getWriter();
        out.println("Post OK");
        out.println("Session id: " + session.getId());
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        out.println("Get OK");
        out.println("Session id: " + session.getId());
        out.println("cname: " + session.getAttribute("cname"));
        out.println("height: " + session.getAttribute("height"));
        out.println("weight: " + session.getAttribute("weight"));
        out.println("bmi: " + session.getAttribute("bmi"));
    }
}
