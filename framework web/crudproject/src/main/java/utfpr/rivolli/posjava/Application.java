package utfpr.rivolli.posjava;

import java.time.LocalDate;
import java.time.Month;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import utfpr.rivolli.posjava.model.Cliente;
import utfpr.rivolli.posjava.model.ClienteRepository;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
    @Bean
    public CommandLineRunner demo(ClienteRepository repository) {
        return (args) -> {
            repository.save(new Cliente("Jack", "Bauer", LocalDate.of(1977, Month.MARCH, 3), "jbauer@yahoo.com.br"));
            repository.save(new Cliente("Chloe", "O'Brian", LocalDate.of(1984, Month.JULY, 11), "chloe1984@terra.com.br"));
        };
    }
}
