package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

//@WebServlet(urlPatterns = {"/controller/upload/file", "/controller/upload/image"})
@WebServlet("/controller/upload/*") // 後置路徑對應 * 代表任意字串(path info)
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 30
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String pathInfo = req.getPathInfo();
        resp.getWriter().print("pathInfo:" + pathInfo + "<p />");

        switch (pathInfo) {
            case "/file":
                uploadFile(req, resp);
                break;
            case "/image":
                uploadImage(req, resp);
                break;
        }
    }

    private void uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("cname"))
                .forEach(part -> {
                    try {
                        String cname = IOUtils.toString(part.getInputStream(),
                                StandardCharsets.UTF_8.name());
                        resp.getWriter().print(part.getName() + " : ");
                        resp.getWriter().print(cname + "<br />");
                    } catch (Exception e) {
                    }
                });

        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("upload_file"))
                .forEach(part -> {
                    try {
                        String data = IOUtils.toString(part.getInputStream(),
                                StandardCharsets.UTF_8.name());
                        resp.getWriter().print(part.getName() + " : ");
                        resp.getWriter().print(data + "<br />");
                    } catch (Exception e) {
                    }
                });
    }

    private void uploadImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("cname"))
                .forEach(part -> {
                    try {
                        String cname = IOUtils.toString(part.getInputStream(),
                                StandardCharsets.UTF_8.name());
                        resp.getWriter().print(part.getName() + " : ");
                        resp.getWriter().print(cname + "<br />");
                    } catch (Exception e) {
                    }
                });

        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("upload_file"))
                .forEach(part -> {
                    try {
                        // 將 InputStream -> byte[] -> base64 字串
                        InputStream is = part.getInputStream();
                        byte[] bytes = IOUtils.toByteArray(is);
                        String data = Base64.getEncoder().encodeToString(bytes);
                        
                        resp.getWriter().print(part.getName() + " : ");
                        resp.getWriter().print(data + "<br />");
                        String img = "<img src='data:image/png;base64, %s'>";
                        img = String.format(img, data);
                        resp.getWriter().print(img + "<br />");
                        
                        // 存檔資料夾
                        String fileSavingFolder = getServletContext().getRealPath("/upload");
                        // 確認資料夾是否存在
                        File folder = new File(fileSavingFolder);
                        if(!folder.exists()) {
                            folder.mkdir(); // 建立資料夾
                        }
                        // 取得檔名
                        String fname = part.getSubmittedFileName();
                        // 存檔路徑
                        String fileSavingPath = fileSavingFolder + File.separator + fname;
                        // 將檔案寫入到伺服器中
                        part.write(fileSavingPath);
                        
                    } catch (Exception e) {
                    }
                });
    }
}
