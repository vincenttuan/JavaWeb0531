package com.web.controller.cookies;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/cookies/write")
public class WriteCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salary = req.getParameter("salary");
        String age    = req.getParameter("age");
        // 建立 Cookies
        Cookie cookieSalary = new Cookie("salary", salary+"");
        Cookie cookieAge = new Cookie("age", age+"");
        // 設定續存時間(秒)
        cookieSalary.setMaxAge(10);
        cookieAge.setMaxAge(10);
        // 將 cookie 寫入 client 端
        resp.addCookie(cookieSalary);
        resp.addCookie(cookieAge);
        
        resp.getWriter().print("Write cookie ok !");
    }
        
}
