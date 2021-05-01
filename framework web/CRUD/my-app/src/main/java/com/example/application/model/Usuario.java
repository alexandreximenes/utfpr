package com.example.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private LocalDate aniversario;
    private String email;
    private String password;
    private String perfil;
    private Boolean aceiteOsTermos;;
    private Status status;

    private static List<Usuario> usuarios = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String telefone, LocalDate aniversario, String email, String password, String perfil, Boolean aceiteOsTermos, Status status) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.aniversario = aniversario;
        this.email = email;
        this.password = password;
        this.perfil = perfil;
        this.aceiteOsTermos = aceiteOsTermos;
        this.status = status;
    }

    public boolean isPersisted() {
        return id != null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Boolean getAceiteOsTermos() {
        return aceiteOsTermos;
    }

    public void setAceiteOsTermos(Boolean aceiteOsTermos) {
        this.aceiteOsTermos = aceiteOsTermos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }
}
