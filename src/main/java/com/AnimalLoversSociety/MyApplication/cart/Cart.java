package com.AnimalLoversSociety.MyApplication.cart;

import com.AnimalLoversSociety.MyApplication.cartitems.CartItem;
import com.AnimalLoversSociety.MyApplication.customers.Customer;
import jakarta.persistence.*;

import java.util.List;

//@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @OneToOne
    @JoinColumn(name = "customerId") // add referencedColumnName?
    private Customer customer;

    @OneToMany // add mappedby?
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(Integer cartId, Customer customer, List<CartItem> cartItems) {
        this.cartId = cartId;
        this.customer = customer;
        this.cartItems = cartItems;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
