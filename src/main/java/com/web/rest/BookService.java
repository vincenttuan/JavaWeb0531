package com.web.rest;

import com.web.rest.bookstore.Book;
import com.web.rest.bookstore.BookDao;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/book")
public class BookService {

    @Path("/")
    @GET
    @Produces("text/plain")
    public String getBooks() {
        return BookDao.getBooks().toString();
    }
    
    @Path("/{id}")
    @GET
    @Produces("text/plain")
    public String getBook(@PathParam("id") Integer id) {
        return BookDao.getBook(id).toString();
    }
    
    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String createBook(@FormParam("id") Integer id, 
                             @FormParam("name") String name,
                             @FormParam("price") Integer price) {
        Book book = new Book(id, name, price);
        return BookDao.createBook(book).toString();
    }

    
}
