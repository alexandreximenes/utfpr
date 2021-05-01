/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import com.api.model.Cidade;
import com.api.model.Cliente;
import com.api.services.ClienteService;
import com.client.CidadeRest;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandre
 */
@Named(value = "clienteJsf")
@RequestScoped
public class ClienteJsf {
    
    private Cliente cliente = new Cliente();
    private int codigo = 0;
    private String nome = "";
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    
    private ClienteService clienteService = new ClienteService();
    private CidadeRest cidadeRest = new CidadeRest();

    public ClienteJsf() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        return cidades = cidadeRest.findAll(List.class);
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Cliente> getClientes() {
        try{
            clientes = clienteService.findAll();
        }catch(Exception e){
            System.out.println("Erro ao buscar clientes: "+e.getMessage());
        }
        return clientes;
    }
    
    public void salvar(int codigo){
        
        if(codigo == 0){
            cliente = new Cliente();                                                                                                                                                                                                                                                                                                                                                                                    
            cliente.setNome(this.nome);
            cliente.setCidade(this.cidade);
            clienteService.save(cliente);
        }else{
            editar(codigo);
        }
        
        this.setNome("");
        this.setCodigo(0);
    }
    
    public void montaEditar(int codigo){
        Cliente cliente = clienteService.getById(codigo);    
        this.setCodigo(codigo);
        this.setNome(cliente.getNome());
        this.setCidade(cliente.getCidade());
        
    }
    public void editar(int codigo){
        cliente = new Cliente();  
        cliente.setNome(this.nome);
        cliente.setCidade(this.cidade);
            
        clienteService.update(codigo, cliente);
    }
    
    public void remover(int codigo) throws Exception{
        clienteService.delete(codigo);
        
    }
    
}
