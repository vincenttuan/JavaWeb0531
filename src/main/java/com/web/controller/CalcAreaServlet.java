package com.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        // 1. 接收參數
        String string_r = req.getParameter("r");
        
        // 2. 商業邏輯運算
        int r = Integer.parseInt(string_r);
        double area = Math.pow(r, 2) * Math.PI;
        
        // 3. 建立分派器與 jsp 位置
        RequestDispatcher rd = req.getRequestDispatcher("/jsps/calcAreaResult.jsp");
        // 3.1 新增/設定 request 屬性, 傳遞給 jsp 頁面使用
        req.setAttribute("result", area);
        // 3.2 傳送
        rd.forward(req, resp);
        //resp.getWriter().print(String.format("r: %d area: %.2f", r, area));
    }
    
}
