/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.model.Cidade;
import br.rs.ClienteRest;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandrelerario
 */
@Named(value = "jsfCidade")
@RequestScoped
public class JsfCidade {

    /**
     * Creates a new instance of JsfCidade
     */
    public JsfCidade() {
    }
    
    public ArrayList<Cidade> getAll(){
        ArrayList<Cidade> lcid = new ArrayList<>();
        ClienteRest cr = new ClienteRest();
        lcid = cr.getJson(ArrayList.class);
        cr.close();
        return lcid;
    }
    
    public void add(){
        Cidade cid = new Cidade(Codigo, nome);
        ClienteRest cr = new ClienteRest();
        cr.putJson(cid);
        cr.close();
    }
    
     public void remove(){
        Cidade cid = new Cidade(Codigo, nome);
        ClienteRest cr = new ClienteRest();
        cr.delete(""+cid.getCodigo());
        cr.close();
    }
    
    
      public void merge(){
        Cidade cid = new Cidade(Codigo, nome);
        ClienteRest cr = new ClienteRest();
        cr.merge(cid);
        cr.close();
    }
     
       public void addParametros(){
        Cidade cid = new Cidade(Codigo, nome);
        ClienteRest cr = new ClienteRest();
        cr.putJsonParametros(cid);
        cr.close();
    }
       public String getXML(){
        ClienteRest cr = new ClienteRest();
        String xml = cr.getXmlCidades(String.class);
        cr.close();
        return xml;
       }
    
    private int Codigo;
    private String nome;
    
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
