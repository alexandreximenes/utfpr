/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import com.api.model.Cliente;
import com.api.services.ClienteService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author alexandre
 */
@Path("clientes")
@RequestScoped
public class ApiResource {

    @Context
    private UriInfo context;
    private ClienteService clienteService = new ClienteService();

    public ApiResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        
        try{
            System.out.println("buscando todos os clientes");
            List<Cliente> clientes = clienteService.findAll();
        
            return Response.status(Response.Status.OK).entity(clientes).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }
    
    @Path("{codigo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("codigo") int codigo) {
        try{
           System.out.println("buscando cliente por codigo: "+codigo);
            Cliente cliente = clienteService.getById(codigo);
            return Response.status(Response.Status.OK).entity(cliente).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }
    
    
    @Path("{codigo}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCliente(@PathParam("codigo") int codigo) {
        try{
            System.out.println("deletando cliente por codigo: "+codigo);
            boolean deletou = clienteService.delete(codigo);
           
            if(deletou)
                return Response.status(Response.Status.OK).build();
            else
                return Response.status(Response.Status.BAD_REQUEST).build();
           
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Cliente cliente) {
        try{
            System.out.println("salvando cliente: "+cliente);
            clienteService.save(cliente);
            return Response.status(Response.Status.CREATED).entity(cliente).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }

    @Path("{codigo}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("codigo") int codigo, Cliente c) {
        
        try{
           System.out.println("atualizando cliente: "+codigo + ", : "+c);
            Cliente cliente = clienteService.update(codigo, c);
            return Response.status(Response.Status.OK).entity(cliente).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }
}
