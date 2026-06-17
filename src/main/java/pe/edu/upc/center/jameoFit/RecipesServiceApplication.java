package pe.edu.upc.center.jameoFit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RecipesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipesServiceApplication.class, args);
    }
}
