package com.web.controller;

import com.web.service.CalaAreaService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/CalcArea") // url-pattern
public class CalcAreaServlet extends HttpServlet {
    
    // 計算 service
    private CalaAreaService service = new CalaAreaService();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收參數
        String string_type = req.getParameter("type");
        String string_r = req.getParameter("r");
        int type = Integer.parseInt(string_type);
        int r = Integer.parseInt(string_r);
        
        // 2. 商業邏輯運算
        double area = service.getAreaResult(type, r);
        String typeName = service.getNameByType(type);
        
        // 3. 建立分派器與 jsp 位置
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/calcAreaResult.jsp");
        // 3.1 新增/設定 request 屬性, 傳遞給 jsp 頁面使用
        req.setAttribute("r", r);
        req.setAttribute("result", String.format("%.2f", area));
        req.setAttribute("typeName", typeName);
        // 3.2 傳送
        rd.forward(req, resp);
        //resp.getWriter().print(String.format("r: %d area: %.2f", r, area));
    }
    
}
