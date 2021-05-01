/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author alexandre
 */
@Path("somar")
@RequestScoped
public class Somar {

    @Context
    private UriInfo context;

    public Somar() {
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Ola mundo";
    }

    @GET
    @Path("/{numero1}/{numero2}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer somar(@PathParam("numero1") int numero1, @PathParam("numero2") int numero2) {
        return numero1 + numero2;
    }
}
