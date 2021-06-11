package com.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/Register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // sno=A01&eno=1z0-900&time=1&time=3&pay=true&memo=GO
        String sno    = req.getParameter("sno");
        String eno    = req.getParameter("eno");
        List<Integer> time = Stream.of(req.getParameterValues("time"))
                                    .map(t -> Integer.parseInt(t))
                                    .collect(toList());
        Boolean pay   = Boolean.parseBoolean(req.getParameter("pay"));
        String memo   = req.getParameter("memo");
        
        // 分派器
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/registerResult.jsp");
        // 配置參數
        
        // 分派
        rd.forward(req, resp);
    }
    
}
