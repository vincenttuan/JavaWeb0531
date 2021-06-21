package com.web.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/secure/*"})
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
        boolean check = false;
        // code here ...
        
        if(check) {
            chain.doFilter(req, res);
        } else {
            res.getWriter().print("Please login !");
        }
    }
    
}
