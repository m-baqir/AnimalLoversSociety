package com.AnimalLoversSociety.MyApplication.cart;

import com.AnimalLoversSociety.MyApplication.cartitems.CartItem;
import com.AnimalLoversSociety.MyApplication.customers.Customer;
import com.AnimalLoversSociety.MyApplication.customers.CustomerService;
import com.AnimalLoversSociety.MyApplication.items.Items;
import com.AnimalLoversSociety.MyApplication.items.ItemsController;
import com.AnimalLoversSociety.MyApplication.sales.Sale;
import com.AnimalLoversSociety.MyApplication.sales.SaleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartService {
    private final ItemsController itemsController;
    private final CustomerService customerService;
    private final SaleService saleService;
    private List<CartItem> cart = new ArrayList<>();

    @Autowired
    public CartService(ItemsController itemsController, CustomerService customerService, SaleService saleService) {
        this.itemsController = itemsController;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    public List<CartItem> getItemsInCart() {
        return Collections.unmodifiableList(cart);
    }

    public void addItem(Items newItem) {
        // Check if cart already contains the item. If yes, then increase the quantity
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

    public double getTotal() {
        double total = 0;
        for (CartItem cartItem : cart) {
            total += cartItem.getItem().getSalePrice() * cartItem.getQuantity();
        }
        return total;
    }

    public Customer saveCustomerInfo(Customer customer) {
        return customerService.saveCustomer(customer);
    }

    public void updateInventory() {
        for (CartItem cartItem : cart) {
            long itemId = cartItem.getItem().getId();
            Items item = itemsController.getItemById(itemId); // Need to get the item from the itemsrepository to link to items table
            item.setInventory(item.getInventory() - cartItem.getQuantity());
        }
    }

    public void saveToSales(Customer customer) {
        for (CartItem cartItem : cart) {
            Sale sale = new Sale();
            long itemId = cartItem.getItem().getId();
            Items item = itemsController.getItemById(itemId); // Need to get the item from the itemsrepository to link to  items table

            sale.setItem(item);
            sale.setCustomer(customer);
            sale.setQuantity(cartItem.getQuantity());
            sale.setDate(LocalDate.now());
            saleService.saveSale(sale);
        }
    }

    public void deleteCart() {
        cart.clear();
    }

}
