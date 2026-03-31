package com.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {
    // Process an HTTP GET requests
    @GET
    @Produces("text/plain")
    public Response getMessage() {
        String output = "Hello World";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{name}")
    @Produces("text/plain")
    public Response getMessage(@PathParam("name") String name) {

        String output = "hello " + name;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/html")
    @Produces("text/html")
    public String doGetAsHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }
}
