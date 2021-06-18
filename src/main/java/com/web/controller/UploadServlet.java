package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns = {"/controller/upload/file", "/controller/upload/image"})
@WebServlet("/controller/upload/*") // 後置路徑對應 * 代表任意字串(path info)
public class UploadServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        resp.getWriter().print(pathInfo);
    }
    
}
