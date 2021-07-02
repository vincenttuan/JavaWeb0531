package com.web.controller;

import com.web.controller.utils.Util;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/authcode")
public class AuthCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authCode = String.format("%04d", new Random().nextInt(10000));
        ImageIO.write(Util.getAuthImg(authCode), "JPEG", resp.getOutputStream());
    }
    
}
