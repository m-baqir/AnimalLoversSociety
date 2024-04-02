package com.AnimalLoversSociety.MyApplication.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

//    @PostMapping
//    public void addCustomer(@RequestBody Customer customer) {
//        customerService.addNewCustomer(customer);
//    }

//    @DeleteMapping(path = "{customerId}")
//    public void deleteCustomer(@PathVariable("customerId") Integer customerId) {
//        customerService.deleteCustomer(customerId);
//    }
}
