package phenrique;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan (
        basePackages = { "phenrique.repository",
                "phenrique.service" }
)
@RestController
public class VendasApplication {

    @Value("${application.name}")
    private String applicationName;

    @Cachorro
    private Animal animal;

    @Bean (name = "executarAnimal")
    public CommandLineRunner executar () {
        return args -> {
            this.animal.fazerBarulho();
        };
    }

    @GetMapping("/hello")
    public String helloPapai() {
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}