package org.ja.customerservice;

import org.ja.customerservice.entities.Customer;
import org.ja.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);

    }

    @Bean
        public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                                   RepositoryRestConfiguration restConfiguration){
    return args -> {

        restConfiguration.exposeIdsFor(Customer.class);
        customerRepository.saveAll(
                List.of(
                        Customer.builder().name("fati").email("fati@gmail.com").build(),
                        Customer.builder().name("hanan").email("hanan@gmail.com").build(),
                        Customer.builder().name("iman").email("iman@gmail.com").build()
                )
        );
        customerRepository.findAll().forEach(customer -> System.out.println(customer.toString()));
    };

    }

}

