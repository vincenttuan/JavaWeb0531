package com.web.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloService {

    // Client: /JavaWeb0531/rest/hello/john
    @Path("/john")
    @GET
    @Produces("text/plain")
    public String helloJohn() {
        return "Hello John !";
    }

    // Client: /JavaWeb0531/rest/hello/1
    // Client: /JavaWeb0531/rest/hello/2?score=100
    @Path("/{id}")
    @GET
    @Produces("text/plain")
    public String helloId(@PathParam("id") Integer id, 
                          @DefaultValue("0") @QueryParam("score") Integer score) {
        return "Hello id = " + id + " score = " + score;
    }
}
