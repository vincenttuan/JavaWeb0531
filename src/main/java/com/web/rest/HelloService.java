package com.web.rest;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
    
    // uri: /rest/hello/john
    // url: http://localhost:8080/JavaWeb0829/rest/hello/john
    @Path("/john")
    @GET
    @Produces("text/plain")
    public String helloJohn() {
        return "Hello John";
    }
    
    @Path("/book")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book helloBook() {
        return new Book("Java", 100);
    }
    
    @Path("/books")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book[] helloBooks() {
        return new Book[]{new Book("Java", 100), new Book("Python", 80)};
    }
    
    @Path("/book_list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> helloBookList() {
        return Arrays.asList(new Book("Java", 100), new Book("Python", 80));
    }
    
    
}
