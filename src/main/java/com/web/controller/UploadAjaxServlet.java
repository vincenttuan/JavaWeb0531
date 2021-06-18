package com.web.controller;

import com.web.controller.utils.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(urlPatterns = {"/controller/upload/ajax"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100) // 100 MB
public class UploadAjaxServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;chartset=UTF-8");

        PrintWriter out = resp.getWriter();

        String title = "";
        String photosBase64 = "";

        for (Part part : req.getParts()) {
            switch (part.getName()) {
                case "title":
                    title = Util.getValue(part.getInputStream());
                    break;
                case "photos":
                    InputStream is = part.getInputStream();
                    photosBase64 = Util.getBase64(is);
                    break;
            }
        }
        String json = "{\"title\":\"%s\", \"photosBase64\":\"%s\"}";
        json = String.format(json, title, photosBase64);
        out.println(json);

    }

}