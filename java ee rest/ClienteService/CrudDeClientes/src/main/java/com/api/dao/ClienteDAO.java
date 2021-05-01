/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dao;

import com.api.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexandre
 */
public class ClienteDAO {
    
    private static List<Cliente> clientes = new ArrayList<>();
    
    public Cliente findById(Integer codigo){
        return clientes.stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
    
    public List<Cliente> findAll(){
        return this.clientes;
    }
    
    
    public Cliente update(Cliente c){
        
        Cliente cliente = this.findById(c.getCodigo());
        if(cliente != null)
            clientes.remove(cliente);
        
        clientes.add(c);
        
        return c;
        
    }
    
    
    public Cliente save(Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }
    
    
    public boolean delete(Integer codigo){
        Cliente cliente = this.findById(codigo);
        if(cliente == null)
            return false;
        
        clientes.remove(cliente);
        return true;
    }
    
     public int nextCodigo(){
        return clientes.size()+1;
    }
}
