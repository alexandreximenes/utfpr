package com.example.application;

import com.example.application.model.Status;
import com.example.application.model.Usuario;
import com.example.application.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.helpers.LaunchUtil;

import java.time.LocalDate;
import java.time.Month;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

    @Bean
    public CommandLineRunner demo(UsuarioRepository repository) {
        return (args) -> {
            repository.save(new Usuario("Alexandre", "Ximenes", "41996605877", LocalDate.of(1990, Month.MARCH, 3), "xyymene, s@gmail.com", "123456", "bla bla bla, bla bla bla, bla bla bla, bla bla bla, ", true, Status.Ativo));
            repository.save(new Usuario("Tiago", "Ximenes", "41996605877", LocalDate.of(1991, Month.MAY, 5), "xyymene, s@gmail.com", "123456", "bla bla bla, bla bla bla, bla bla bla, bla bla bla, ", true, Status.Ativo));
            repository.save(new Usuario("Arthur", "Ximenes", "41996605877", LocalDate.of(2015, Month.JANUARY, 1), "xyymene, s@gmail.com", "123456", "bla bla bla, bla bla bla, bla bla bla, bla bla bla, ", true, Status.Inativo));
            repository.save(new Usuario("Amanda", "Ximenes", "41996605877", LocalDate.of(2019, Month.NOVEMBER, 3), "xyymene, s@gmail.com", "123456", "bla bla bla, bla bla bla, bla bla bla, bla bla bla, ", true, Status.Descartado));
            repository.save(new Usuario("Dayane", "Ximenes", "41996605877", LocalDate.of(1995, Month.OCTOBER, 10), "xyymene, s@gmail.com", "123456", "bla bla bla, bla bla bla, bla bla bla, bla bla bla, ", true, Status.Prospecao));
        };
    }

}
