/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import com.api.model.Cidade;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:JavaEE8Resource [javaee8]<br>
 * USAGE:
 * <pre>
 *        ClientRest client = new ClientRest();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author alexandre
 */
public class CidadeRest {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://maventest.herokuapp.com/mavenTest-1.0-SNAPSHOT/webresources";

    public CidadeRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cidade");
    }

    public <T> T findAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
     public <T> T findById(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
     
    public void delete(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }
      
    public void save(Object cidade) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .post(javax.ws.rs.client.Entity.entity(cidade, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }
       
    public void put(Object cidade) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .put(javax.ws.rs.client.Entity.entity(cidade, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    
    public void putParam(Cidade cidade) throws ClientErrorException {
        webTarget.queryParam("codigo", cidade.getCodigo())
                .queryParam("nome", requestEntity.getNome())
                .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .put(javax.ws.rs.client.Entity.entity(cidade, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }
   

    public void close() {
        client.close();
    }    
}
