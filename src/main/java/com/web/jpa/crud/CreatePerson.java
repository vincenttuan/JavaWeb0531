package com.web.jpa.crud;

import com.github.javafaker.Faker;
import com.web.jpa.entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/person/create")
public class CreatePerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Faker faker = new Faker();
        Random r = new Random();
        // 建立 Person
        Person person = new Person();
        person.setName(faker.pokemon().name());
        person.setAge(r.nextInt(20));
        // 取得 EntityManagerFactory
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        // 取得 EntityManger
        EntityManager em = emf.createEntityManager();
        // 操作 CRUD
        // 建立交易模式
        EntityTransaction et = em.getTransaction();
        et.begin(); // 交易開始
        em.persist(person); // 將 person 持久化 (Save/Update)
        et.commit();// 提交
        em.close();// 關閉
        out.print(person + " 建立成功");
    }
    
}
