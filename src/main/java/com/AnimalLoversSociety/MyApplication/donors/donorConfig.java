package com.AnimalLoversSociety.MyApplication.donors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class donorConfig {
    @Bean
    CommandLineRunner donorRunner(donorRepository repository) {
        return args -> {
            if (repository.findByName("Arsh").isEmpty()) {
                donor donor1 = new donor(
                        "Arsh",
                        "ON, Canada",
                        "Male",
                        5000,
                        "No",
                        "Yes"
                );
                repository.save(donor1);
            }

            if (repository.findByName("Alex").isEmpty()) {
                donor donor2 = new donor(
                        "Alex",
                        "ON, Canada",
                        "Male",
                        200,
                        "No",
                        "Yes"
                );
                repository.save(donor2);
            }
        };
    }
}
