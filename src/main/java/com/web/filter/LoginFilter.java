package com.web.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = {"/secure/*"})
public class LoginFilter extends HttpFilter {

    private static Map<String, String> users = new LinkedHashMap<>();

    static {
        users.put("John", "1234");
        users.put("Mary", "5678");
        users.put("Jean", "0000");
        users.put("admin", "9999");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        boolean check = false;
        // code here ...
        check = users.entrySet()
                        .stream()
                        .filter(e -> e.getKey().equals(username) && 
                                     e.getValue().equals(password))
                        .findAny()
                        .isPresent();
        
        if (check) {
            
            chain.doFilter(req, res);
            
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
            if(!(username==null&&password==null)) {
                req.setAttribute("errorMsg", "登入錯誤");
            }
            rd.forward(req, res);
        }
    }

}
