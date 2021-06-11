package com.web.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/BMI")
public class BMIServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        // 顯示內容：HTTP 文件 (Part 4)
        InputStreamReader isr = new InputStreamReader(req.getInputStream());
        char[] buffer = new char[1];
        while (isr.read(buffer) != -1) {
            out.print(new String(buffer));
        }
    }
}
