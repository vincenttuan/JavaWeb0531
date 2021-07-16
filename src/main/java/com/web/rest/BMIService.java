package com.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/bmi")
public class BMIService {
    // Client: /JavaWeb0531/rest/bmi/170/60
    @Path("/{h}/{w}")
    @GET
    @Produces(MediaType.TEXT_PLAIN) // "text/plain"
    public String calcBmi_1(@PathParam("h") Double h, @PathParam("w") Double w) {
        double bmi = w / Math.pow(h/100.0, 2);
        return String.format("BMI = %.2f", bmi);
    }
    
    // Client: /JavaWeb0531/rest/bmi/?h=170&w=60
    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN) // "text/plain"
    public String calcBmi_2(@QueryParam("h") Double h, @QueryParam("w") Double w) {
        double bmi = w / Math.pow(h/100.0, 2);
        return String.format("BMI = %.2f", bmi);
    }
}
