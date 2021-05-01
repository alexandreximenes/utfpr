/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dao;

import com.api.model.Cidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexandre
 */
public class CidadeDAO {
    
    private static List<Cidade> cidades = new ArrayList<>();

    public CidadeDAO() {
        cidades.addAll(List.of(new Cidade(1, "Curitiba"), new Cidade(2, "Sã Paulo"), new Cidade(3, "Rio de Janeiro")));
    }
    
    
    
    public Cidade findById(Integer codigo){
        return cidades.stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
    
    public List<Cidade> findAll(){
        return this.cidades;
    }
    
    
    public Cidade update(Cidade c){
        
        Cidade cidade = this.findById(c.getCodigo());
        if(cidade != null)
            cidades.remove(cidade);
        
        cidades.add(c);
        
        return c;
        
    }
    
    
    public Cidade save(Cidade cidade){
        cidades.add(cidade);
        return cidade;
    }
    
    
    public boolean delete(Integer codigo){
        Cidade cidade = this.findById(codigo);
        if(cidade == null)
            return false;
        
        cidades.remove(cidade);
        return true;
    }
    
     public int nextCodigo(){
        return cidades.size()+1;
    }
}
