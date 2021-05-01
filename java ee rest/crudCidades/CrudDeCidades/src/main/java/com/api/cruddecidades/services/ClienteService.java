/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.cruddecidades.services;

import com.api.cruddecidades.dao.ClienteDAO;
import com.api.cruddecidades.model.Cliente;
import java.util.List;

/**
 *
 * @author alexandre
 */
public class ClienteService {
    
    private static ClienteDAO clienteDao = new ClienteDAO();
    
    public Cliente getById(Integer codigo){
        Cliente cliente = clienteDao.findById(codigo);
        if(cliente == null){
            throw new RuntimeException("Cliente não encontrado");
        }
        
        return cliente;
    }
    
    public List<Cliente> findAll(){
        
        if(clienteDao.findAll().size() == 0)
            throw new RuntimeException("Nenhum cliente cadastrado");
        
        return clienteDao.findAll();
    }
    
    
    public Cliente update(Integer codigo, Cliente c){
        Cliente cliente = clienteDao.findById(codigo);
        
        if(cliente == null)
            throw new RuntimeException("Cliente não encontrado");
        
        
        if(c.getNome().isBlank())
            throw new RuntimeException("Nome do cliente invalido");
        
        if(c.getCidade().isBlank())
            throw new RuntimeException("Cidade do cliente invalido");
        
        cliente.setCodigo(c.getCodigo());
        cliente.setNome(c.getNome());
        cliente.setCidade(c.getCidade());
        
        return clienteDao.update(codigo, cliente);
        
    }
    
    
    public Cliente save(Cliente cliente){
        
        if(cliente == null)
            throw new RuntimeException("Dados invalidos");
        
        if(cliente.getNome().isBlank())
            throw new RuntimeException("Nome do cliente invalido");
        
        if(cliente.getCidade().isBlank())
            throw new RuntimeException("Cidade do cliente invalido");
        
        cliente.setCodigo(clienteDao.nextCodigo());
        
        clienteDao.save(cliente);
        
        return cliente;
    }
    
    
    public boolean delete(Integer id) throws Exception{
        
        Cliente cliente = this.getById(id);
        if(cliente == null){
            throw new Exception("Cliente não encontrado");
        }
        
        boolean deletou = clienteDao.delete(id);
        if(deletou)
            return true;
        else 
            return false;
        
    }
}
