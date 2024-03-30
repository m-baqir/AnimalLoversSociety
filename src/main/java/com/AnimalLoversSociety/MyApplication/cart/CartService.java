package com.AnimalLoversSociety.MyApplication.cart;

import com.AnimalLoversSociety.MyApplication.cartitems.CartItem;
import com.AnimalLoversSociety.MyApplication.customers.Customer;
import com.AnimalLoversSociety.MyApplication.items.Items;
import com.AnimalLoversSociety.MyApplication.items.ItemsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartService {
    private final ItemsRepository itemsRepository;
    private List<CartItem> cart = new ArrayList<>();

    @Autowired
    public CartService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
        //cart = new ArrayList<>();
    }

    public void addItem(Items newItem) {
        // Check if cart already contains the item, if yes, then increase the quantity
        boolean exists = false;
        for (CartItem cartItem : cart) {
            if (cartItem.getItem().getId() == newItem.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                exists = true;
            }
        }
        // Add the item to the cart
        if (!exists) {
            cart.add(new CartItem(newItem,1));
        }
    }

    public void removeItem(Items item) {
        for (int i = cart.size() - 1; i >= 0; i--) {
            CartItem cartItem = cart.get(i);
            if (cartItem.getItem().getId() == item.getId()) {
                cart.remove(cartItem);
            }
        }
    }

    public List<CartItem> getItemsInCart() {
        return Collections.unmodifiableList(cart);
    }
}
