package com.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
    // Client: /JavaWeb0531/rest/hello/2
    @Path("/{id}")
    @GET
    @Produces("text/plain")
    public String helloId(@PathParam("id") Integer id) {
        return "Hello id = " + id;
    }
}
