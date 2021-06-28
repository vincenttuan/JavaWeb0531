package com.web.controller;

import com.github.javafaker.Faker;
import com.web.vo.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/recruit")
public class RecruitServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int amount = Integer.parseInt(req.getParameter("amount"));
        List<Person> list = new ArrayList<>();
        Faker faker = new Faker();
        Random r = new Random();
        for(int i=0;i<amount;i++) {
            Person p = new Person(
                    faker.name().firstName(), 
                    r.nextInt(100)%2 == 0 ? "男" : "女" , 
                    r.nextInt(101));
            list.add(p);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/recruit_result.jsp");
        req.setAttribute("list", list);
        rd.forward(req, resp);
    }
    
}
