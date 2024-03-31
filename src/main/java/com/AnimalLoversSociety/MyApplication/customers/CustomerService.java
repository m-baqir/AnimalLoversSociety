package com.AnimalLoversSociety.MyApplication.customers;

import com.AnimalLoversSociety.MyApplication.seminars.Seminar;
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
        Customer customer = customerRepository.getCustomerByFirstNameAndLastName(newCustomer.getFirstName(), newCustomer.getLastName());
        return customer;
    }

    public void saveCustomer(Customer customer) {
        // If customer already present in database, update info
        Customer existingCustomer = getCustomerIfPresent(customer);
        if (existingCustomer != null) {
            existingCustomer.setCustomerId(existingCustomer.getCustomerId());
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setStreetAddress(customer.getStreetAddress());
            existingCustomer.setCity(customer.getCity());
            existingCustomer.setProvince(customer.getProvince());
            existingCustomer.setPostalCode(customer.getPostalCode());
           customerRepository.save(existingCustomer);

        }
        else
            customerRepository.save(customer);
    }
}
