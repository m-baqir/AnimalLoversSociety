package com.AnimalLoversSociety.MyApplication.customers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This class adds sample data to the database
@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner customerRunner(CustomerRepository repository) {
        return args -> {
            // if condition prevents the same sample data being entered into the database every time the server is started
            if (repository.findByFirstNameAndLastName("John","Smith").isEmpty()) {
                Customer customer1 = new Customer(
                        "John",
                        "Smith",
                        "123 Apple St",
                        "Toronto",
                        "ON",
                        "M2K 1W9"
                );
                repository.save(customer1);
            }

            if (repository.findByFirstNameAndLastName("Amy","Roberts").isEmpty()) {
                Customer customer2 = new Customer(
                        "Amy",
                        "Roberts",
                        "456 Peach St",
                        "Toronto",
                        "ON",
                        "M3K 0C3"
                );
                repository.save(customer2);
            }
        };
    }
}
