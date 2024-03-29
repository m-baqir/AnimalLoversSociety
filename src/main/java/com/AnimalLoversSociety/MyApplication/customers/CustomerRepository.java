package com.AnimalLoversSociety.MyApplication.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
