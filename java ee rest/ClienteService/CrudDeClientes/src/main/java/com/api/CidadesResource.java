/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import com.api.model.Cidade;
import com.api.services.CidadeService;
import com.client.CidadeRest;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("cidades")
@RequestScoped
public class CidadesResource {

    @Context
    private UriInfo context;
    private CidadeRest cidadeRest = new CidadeRest();

    public CidadesResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCdades() {
        
        try{
            System.out.println("buscando todos as cidades");
            List<Cidade> cidades = cidadeRest.findAll(List.class);
        
            return Response.status(Response.Status.OK).entity(cidades).build();
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
           System.out.println("buscando cidade por codigo: "+codigo);
            Cidade cidade = cidadeRest.findById(Cidade.class, codigo);
            return Response.status(Response.Status.OK).entity(cidade).build();
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
            System.out.println("deletando cidade por codigo: "+codigo);
            cidadeRest.delete(String.valueOf(codigo));
            return Response.status(Response.Status.OK).build();
            
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Cidade cidade) {
        try{
            int nextCodigo = 0;
            System.out.println("salvando cidade: "+cidade);
            List<Cidade> cidades = cidadeRest.findAll(List.class);
            if(cidades.size() == 0){
                nextCodigo = 1;
            }else{
                nextCodigo = cidades.size() + 1;
            }
                
            cidade.setCodigo(nextCodigo);
            cidadeRest.save(cidade);
            return Response.status(Response.Status.CREATED).entity(cidade).build();
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
    public Response update(@PathParam("codigo") int codigo, Cidade c) {
        
        try{
           System.out.println("atualizando cidade: "+codigo + ", : "+c);
           c.setCodigo(codigo);
           cidadeRest.put(c);
           return Response.status(Response.Status.OK).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

}
