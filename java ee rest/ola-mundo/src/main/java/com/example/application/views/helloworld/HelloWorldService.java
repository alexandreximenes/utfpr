package com.example.application.views.helloworld;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class HelloWorldService {

    public void validation(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Informe seu nome!");
        }
    }

   public Integer convert(String number) throws Exception {
       Integer mValor = 0;

       if (number == null || number.isEmpty()) {
           throw new Exception("Numero de repetições não pode ser vazio");
       }

       try{
           mValor = Integer.parseInt(number);
       }catch (Exception e){
          throw new Exception("Erro ao converter (" + number+ ") em numero");
       }

       return mValor;
   }
}
