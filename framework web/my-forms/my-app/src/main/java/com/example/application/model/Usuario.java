package com.example.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    /*
    *    private TextField nome, sobreNome, telefone;
    DatePicker aniversario;
    private EmailField email;
    private Button button;
    IntegerField idade;
    TextArea perfil;
    * */

    private String nome;
    private String sobrenome;
    private String telefone;
    private LocalDate aniversario;
    private String email;
    private String password;
    private Integer idade;
    private String perfil;
    private Cidade cidade;
    private Boolean aceiteOsTermos;;

    private static List<Usuario> usuarios = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String telefone, LocalDate aniversario, String email, String password, Integer idade, String perfil, Cidade cidade, Boolean aceiteOsTermos) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.aniversario = aniversario;
        this.email = email;
        this.password = password;
        this.idade = idade;
        this.perfil = perfil;
        this.cidade = cidade;
        this.aceiteOsTermos = aceiteOsTermos;
    }

    public static List<Usuario> lista() {
        return usuarios;
    }

    public static List<Usuario> add(Usuario usuario) {
        usuarios.add(usuario);
        return usuarios;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Boolean getAceiteOsTermos() {
        return aceiteOsTermos;
    }

    public void setAceiteOsTermos(Boolean aceiteOsTermos) {
        this.aceiteOsTermos = aceiteOsTermos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", aniversario=" + aniversario +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", idade=" + idade +
                ", perfil='" + perfil + '\'' +
                ", cidade=" + cidade +
                ", aceiteOsTermos=" + aceiteOsTermos +
                '}';
    }
}
