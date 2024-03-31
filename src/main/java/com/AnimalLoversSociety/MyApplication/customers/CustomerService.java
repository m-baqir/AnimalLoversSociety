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
//        if (customer != null)
//            return customerRepository.findById(customer.getCustomerId()).get();
//        else
//            return null;
        return customer;
    }

    public Customer saveCustomer(Customer customer) {
        // If customer already present in database, update info
        Customer existingCustomer = getCustomerIfPresent(customer);
        if (existingCustomer != null) {
            // id, firstname, lastname?
           existingCustomer.setStreetAddress(customer.getStreetAddress());
           existingCustomer.setCity(customer.getCity());
           existingCustomer.setProvince(customer.getProvince());
           existingCustomer.setPostalCode(customer.getPostalCode());
        }

        return customerRepository.save(customer);
    }

//    public void deleteCustomer(Integer customerId) {
//        customerRepository.deleteById(customerId);
//    }
}
