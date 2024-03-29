package com.AnimalLoversSociety.MyApplication.sales;

import com.AnimalLoversSociety.MyApplication.customers.Customer;
import com.AnimalLoversSociety.MyApplication.customers.CustomerRepository;
import com.AnimalLoversSociety.MyApplication.items.Items;
import com.AnimalLoversSociety.MyApplication.items.ItemsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

// This class adds sample data to the database
@Configuration
public class SaleConfig {
    @Bean
    CommandLineRunner saleRunner(SaleRepository saleRepository, CustomerRepository customerRepository, ItemsRepository itemsRepository) {
        return args -> {

            Items item1 = new Items(
                   "Animal Book 1" ,"book", 20, 16, 300
            );
            Items item2 = new Items(
                    "Animal book 2","video", 15, 12, 300
            );
            itemsRepository.saveAll(List.of(item1, item2));

            Sale sale1 = new Sale(1, LocalDate.parse("2024-03-03"));
            Sale sale2= new Sale(2, LocalDate.parse("2024-03-15"));
            sale1.setItem(item1);
            sale2.setItem(item2);

            // if condition prevents the same sample data being entered into the database every time the server is started
            if (customerRepository.findByFirstNameAndLastName("Cam","Adams").isEmpty()) {
                Customer customer1 = new Customer(
                        "Cam", "Adams", "246 Orange St", "Vancouver", "BC", "V5K0A3"
                );
                customerRepository.save(customer1);
                sale1.setCustomer(customer1);
                saleRepository.save(sale1);
            }
            if (customerRepository.findByFirstNameAndLastName("Claire","Benson").isEmpty()) {
                Customer customer2 = new Customer(
                        "Claire", "Benson", "357 Lemon Dr", "Vancouver", "BC", "V5K0B5"
                );
                customerRepository.save(customer2);
                sale2.setCustomer(customer2);
                saleRepository.save(sale2);
            }
        };
    }
}
