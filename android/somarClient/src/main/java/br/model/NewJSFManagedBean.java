/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;

import br.client.SomarClient;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandre
 */
@Named(value = "somar")
@RequestScoped
public class NewJSFManagedBean {

    private Integer numero1;
    private Integer numero2;
    private Integer resultado;
    
    public NewJSFManagedBean() {
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public Integer getResultado() {
        return resultado;
    }

    public Integer getNumero1() {
        return numero1;
    }

    public Integer getNumero2() {
        return numero2;
    }

    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(Integer numero2) {
        this.numero2 = numero2;
    }
    
    public void serviceSoma(){
    
        SomarClient somarClient = new SomarClient();
        resultado = somarClient.somar(numero1, numero2);
    }
    
    
}
