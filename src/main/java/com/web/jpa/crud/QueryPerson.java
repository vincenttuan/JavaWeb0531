package com.web.jpa.crud;

import com.web.jpa.entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/person/query")
public class QueryPerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 取得 EntityManagerFactory
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        // 取得 EntityManger
        EntityManager em = emf.createEntityManager();
        // 全部查詢
        //Query query = em.createQuery("select p from Person p");
        //out.print(query.getResultList());
        List<Person> list = em.createNamedQuery("Person.findAll").getResultList();
        out.print(list);
        out.print("<hr>");
        // 帶入條件查詢
        list = em.createNamedQuery("Person.findByAge")
                .setParameter("age", 18)
                .getResultList();
        out.print(list);
        
    }
}
