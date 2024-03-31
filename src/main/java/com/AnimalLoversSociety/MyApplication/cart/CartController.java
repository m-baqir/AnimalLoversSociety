package com.AnimalLoversSociety.MyApplication.cart;

import com.AnimalLoversSociety.MyApplication.customers.Customer;
import com.AnimalLoversSociety.MyApplication.items.Items;
import com.AnimalLoversSociety.MyApplication.items.ItemsController;
import com.AnimalLoversSociety.MyApplication.seminars.Seminar;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
    private final CartService cartService; // has access to itemsRepository through this?
    private final ItemsController itemsController; // need to use itemRepo and find by id

    @Autowired
    public CartController(CartService cartService, ItemsController itemsController) {
        this.cartService = cartService;
        this.itemsController = itemsController;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getItemsInCart());
        model.addAttribute("total", cartService.getTotal());
        return "cart";
    }

    @PostMapping("/cart/add/{id}")
    public String addItemToCart(@PathVariable long id, @ModelAttribute("item") Items item, Model model) {
        cartService.addItem(itemsController.getItemById(id));
        return "redirect:/items/shop";
    }

    @GetMapping("/cart/{id}")
    public String removeItemFromCart(@PathVariable long id) {
        cartService.removeItem(itemsController.getItemById(id));
        return "redirect:/cart";
    }

    @GetMapping("cart/checkout")
    public String showCheckoutForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "cart_checkout";
    }

    @PostMapping("/cart/checkout")
    public String placeOrder(@ModelAttribute("customer") Customer customer) {
        cartService.saveCustomerInfo(customer);
        cartService.updateInventory();
        cartService.saveToSales(customer);
        cartService.deleteCart();
        //return "cart_confirm";
        return "redirect:/items/shop";
    }
}
