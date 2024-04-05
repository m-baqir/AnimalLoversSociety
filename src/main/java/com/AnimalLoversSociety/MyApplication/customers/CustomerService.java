package com.AnimalLoversSociety.MyApplication.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerIfPresent(Customer newCustomer) {
        Customer customer = customerRepository.getCustomerByFirstNameAndLastNameAndStreetAddress(
                newCustomer.getFirstName(), newCustomer.getLastName(), newCustomer.getStreetAddress());
        return customer;
    }

    public Customer saveCustomer(Customer customer) {
        // If customer already present in database, update info
        Customer existingCustomer = getCustomerIfPresent(customer);
        if (existingCustomer != null) {
            existingCustomer.setCity(customer.getCity());
            existingCustomer.setProvince(customer.getProvince());
            existingCustomer.setPostalCode(customer.getPostalCode());
            return customerRepository.save(existingCustomer);

        }
        else
            return customerRepository.save(customer);
    }
}
