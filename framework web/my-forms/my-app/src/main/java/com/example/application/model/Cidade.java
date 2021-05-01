package com.example.application.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Cidade {

    private String nome;
    private static List<Cidade> cidades = new ArrayList<>();


    public Cidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<Cidade> getCidades(){
        cidades = asList(new Cidade("Curitiba"),
                new Cidade("São Paulo"),
                new Cidade("Santa catarina"),
                new Cidade("Rio de janeiro")
                );
        return cidades;
    }
}
