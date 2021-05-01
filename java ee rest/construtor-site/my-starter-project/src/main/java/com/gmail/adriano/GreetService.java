package com.gmail.adriano;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Informe seu nome!";
        } else {
            return "Olá " + name;
        }
    }

}
