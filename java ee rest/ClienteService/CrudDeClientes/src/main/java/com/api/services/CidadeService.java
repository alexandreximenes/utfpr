/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.services;

import com.api.dao.CidadeDAO;
import com.api.model.Cidade;
import java.util.List;

/**
 *
 * @author alexandre
 */
public class CidadeService {
    
    private static CidadeDAO cidadeDao = new CidadeDAO();
    
    public Cidade getById(Integer codigo){
        Cidade cidade = cidadeDao.findById(codigo);
        if(cidade == null){
            throw new RuntimeException("Cidade não encontrada");
        }
        
        return cidade;
    }
    
    public List<Cidade> findAll(){
        
        if(cidadeDao.findAll().size() == 0)
            throw new RuntimeException("Nenhuma cidade cadastrada");
        
        return cidadeDao.findAll();
    }
    
    
    public Cidade update(Integer codigo, Cidade c){
        Cidade cidade = cidadeDao.findById(codigo);
        
        if(cidade == null)
            throw new RuntimeException("Cidade não encontrada");
        
        
        if(c.getNome().isBlank())
            throw new RuntimeException("Nome da cidade invalido");
        
        cidade.setCodigo(codigo);
        cidade.setNome(c.getNome());
        
        return cidadeDao.update(cidade);
        
    }
    
    
    public Cidade save(Cidade cidade){
        
        if(cidade == null)
            throw new RuntimeException("Dados invalidos");
        
        if(cidade.getNome().isBlank())
            throw new RuntimeException("Nome do cidade invalida");
        
        
        cidade.setCodigo(cidadeDao.nextCodigo());
        
        cidade = cidadeDao.save(cidade);
        
        return cidade;
    }
    
    
    public boolean delete(Integer id) throws Exception{
        
        Cidade cidade = this.getById(id);
        if(cidade == null){
            throw new Exception("Cidade não encontrada");
        }
        
        boolean deletou = cidadeDao.delete(id);
        if(deletou)
            return true;
        else 
            return false;
        
    }
}
