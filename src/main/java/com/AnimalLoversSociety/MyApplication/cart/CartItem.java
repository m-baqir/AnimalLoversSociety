package com.AnimalLoversSociety.MyApplication.cart;

import com.AnimalLoversSociety.MyApplication.items.Items;
import jakarta.persistence.*;

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;
    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Items item;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Items item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
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

}
