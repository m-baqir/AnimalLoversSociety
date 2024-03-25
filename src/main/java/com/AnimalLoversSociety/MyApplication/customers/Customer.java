package com.AnimalLoversSociety.MyApplication.customers;

import com.AnimalLoversSociety.MyApplication.sales.Sale;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;

    // No-arg constructor
    public Customer() {
    }

    // Constructor with all fields
//    public Customer(Integer customerId,
//                    String firstName,
//                    String lastName,
//                    String streetAddress,
//                    String city,
//                    String province,
//                    String postalCode) {
//        this.customerId = customerId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.streetAddress = streetAddress;
//        this.city = city;
//        this.province = province;
//        this.postalCode = postalCode;
//    }

    // Constructor without id (will be auto-generated)
    public Customer(String firstName,
                    String lastName,
                    String streetAddress,
                    String city,
                    String province,
                    String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    // Getters and setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
