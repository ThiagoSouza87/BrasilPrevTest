package br.com.brasilprev.brasilprevteste.config;

import br.com.brasilprev.brasilprevteste.model.Customer;
import br.com.brasilprev.brasilprevteste.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Customer("Bilbo Baggins TESTE UM", "123456789", "Avenida Paulista - n 235")));
            log.info("Preloading " + repository.save(new Customer("Frodo Baggins TESTE DOIS", "9876543221" , "Avenida Bandeirantes  - n 666")));
        };
    }
}
