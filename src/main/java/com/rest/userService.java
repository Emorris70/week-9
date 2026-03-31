package com.rest;

import com.rest.entity.User;
import com.rest.persistence.GenericDao;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * RESTful resource representing the user table.
 */
@Path("/user")
public class userService {
    GenericDao<User> dao = new GenericDao<>(User.class);

    /**
     * Gets a list of all users
     *
     * @return list of users
     */
    @GET
    @Path("/users")
    @Produces("application/json")
    public Response getAllUsers() {
        List<User> userList = dao.getAll();
        return Response.status(200).entity(userList).build();
    }

    /**
     * Gets a user by id
     *
     * @param id the user id
     * @return the specific user of choice by id
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUserById(@PathParam("id") int id) {
        User userList = dao.getById(id);
        return Response.status(200).entity(userList).build();
    }
}
