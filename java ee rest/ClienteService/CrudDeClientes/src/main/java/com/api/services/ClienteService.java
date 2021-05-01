/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.services;

import com.api.dao.CidadeDAO;
import com.api.dao.ClienteDAO;
import com.api.model.Cidade;
import com.api.model.Cliente;
import com.client.CidadeRest;
import java.util.List;

/**
 *
 * @author alexandre
 */
public class ClienteService {
    
    private static ClienteDAO clienteDao = new ClienteDAO();
    private static CidadeDAO cidadeDao = new CidadeDAO();
    private CidadeRest cidadeRest = new CidadeRest();

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
        
        if(c.getCidade() == null || (c.getCidade() != null && c.getCidade().getCodigo() == null)){
            throw new RuntimeException("Cidade invalida");
        }
        
        Cidade cidade = cidadeRest.findById(Cidade.class, c.getCidade().getCodigo());
        if(cidade == null){
            throw new RuntimeException("Cidade não cadastrada");
        }   
        
        cliente.setCodigo(codigo);
        cliente.setNome(c.getNome());
        cliente.setCidade(cidade);
        
        return clienteDao.update(cliente);
        
    }
    
    
    public Cliente save(Cliente cliente){
        
        if(cliente == null)
            throw new RuntimeException("Dados invalidos");
        
        if(cliente.getNome().isBlank())
            throw new RuntimeException("Nome do cliente invalido");
        
        if(cliente.getCidade() == null || (cliente.getCidade() != null && cliente.getCidade().getCodigo() == null)){
            throw new RuntimeException("Cidade invalida");
        }
        
        Cidade cidade = cidadeRest.findById(Cidade.class, cliente.getCidade().getCodigo());
        if(cidade == null){
            throw new RuntimeException("Cidade não cadastrada");
        }
        
        cliente.setCodigo(clienteDao.nextCodigo());
        cliente.setCidade(cidade);
        
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
