package com.AnimalLoversSociety.MyApplication.cartitems;

import com.AnimalLoversSociety.MyApplication.cart.Cart;
import com.AnimalLoversSociety.MyApplication.items.Items;
import jakarta.persistence.*;

//@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;
    @ManyToOne // One product can be in many shopping carts (referenced by several cart items)
    @JoinColumn(name = "itemId", nullable = false)
    private Items item;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "cartId", nullable = false)
    private Cart cart;

    public CartItem() {
    }
//
//    public CartItem(Integer cartItemId, Items item, int quantity, Cart cart) {
//        this.cartItemId = cartItemId;
//        this.item = item;
//        this.quantity = quantity;
//        this.cart = cart;
//    }

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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
