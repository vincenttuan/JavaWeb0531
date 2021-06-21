package com.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/secure/*")
public class WatermarkFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        
        MyResponse myRes = new MyResponse(res);
        
        chain.doFilter(req, myRes);
        
        String html = myRes.getHTMLString();
        String wm = "<body background='/JavaWeb0531/images/do_not_copy.png'";
        html = html.replaceAll("<body", wm);
        
        res.getWriter().print(html);
    }
    
}
