package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
    Client請求URL http://localhost:8080/JavaWeb0531/hi?name=John
    /JavaWeb0531 -> Context path, 要到 META-INF/context.xml 中設定與配置
    /hi          -> url-pattern,  要到 WEB-INF/web.xml 中設定與配置
*/
public class HelloGenericServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // req 表示收到 client 的請求資訊 
        String name = req.getParameter("name");
        
        // res 表示要回應給 client 端的內容
        System.out.printf("Hi %s %s\n", name, new Date()); // 印在 Server 的 console 中 (通常用於 debug 或開發上觀察變數)
        PrintWriter out = res.getWriter(); // 透過 out 可以將訊息回傳給 client
        out.print("Hi: "); // 把訊息寫在 HTTP Response 文件的 Part 4
        out.print(name);
        out.print(" " + new Date());
        //out.close();
    }
    
}
