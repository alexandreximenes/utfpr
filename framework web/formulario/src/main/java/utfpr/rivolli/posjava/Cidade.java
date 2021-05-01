/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.rivolli.posjava;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rivolli
 */
public class Cidade {
    private int id;
    private String nome;
    private String estado;

    public Cidade(int id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public static Set<Cidade> lista() {
        HashSet<Cidade> cidades = new HashSet<>();
        cidades.add(new Cidade(1, "Londrina", "PR"));
        cidades.add(new Cidade(2, "Curitiba", "PR"));
        cidades.add(new Cidade(3, "São Paulo", "SP"));
        cidades.add(new Cidade(4, "Florianópolis", "SC"));
        cidades.add(new Cidade(4, "Belo Horizonte", "MG"));
        return cidades;
    }
    
    @Override
    public String toString() {
        return nome + " - " + estado;
    }
}
