package com.AnimalLoversSociety.MyApplication.sales;
import com.AnimalLoversSociety.MyApplication.customers.Customer;
import com.AnimalLoversSociety.MyApplication.items.Items;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Items item;
    private int quantity;
    private LocalDate date;

    // No-arg constructor
    public Sale() {
    }

    // Constructor with all fields
//    public Sale(Integer saleId, Customer customer, Items item, int quantity, LocalDate date) {
//        this.saleId = saleId;
//        this.customer = customer;
//        this.item = item;
//        this.quantity = quantity;
//        this.date = date;
//    }

    // Constructor without saleId (will be auto-generated)
    public Sale(Customer customer, Items item, int quantity, LocalDate date) {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;
        this.date = date;
    }

    /* Constructor without Customer and Item field
    First need to instantiate a Customer and a Sale
    Then use the setCustomer and setItem methods (or else customerId and item_code field will be null and cause an error)
                 */
    public Sale(int quantity, LocalDate date) {
        this.quantity = quantity;
        this.date = date;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
