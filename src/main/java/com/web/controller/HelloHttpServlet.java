package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    Client請求URL http://localhost:8080/JavaWeb0531/hello?name=John
    /JavaWeb0531 -> Context path, 要到 META-INF/context.xml 中設定與配置
    /hello       -> url-pattern,  要到 WEB-INF/web.xml 中設定與配置
*/
public class HelloHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        // req 表示收到 client 的請求資訊 
        String name = req.getParameter("name");
        
        // res 表示要回應給 client 端的內容
        System.out.printf("Hello %s %s\n", name, new Date()); // 印在 Server 的 console 中 (通常用於 debug 或開發上觀察變數)
        PrintWriter out = resp.getWriter(); // 透過 out 可以將訊息回傳給 client
        out.print("Hello: "); // 把訊息寫在 HTTP Response 文件的 Part 4
        out.print(name);
        out.print(" " + new Date());
        //out.close();
    }

    
}
