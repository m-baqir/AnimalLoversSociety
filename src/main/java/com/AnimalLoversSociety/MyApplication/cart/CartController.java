package com.AnimalLoversSociety.MyApplication.cart;

import com.AnimalLoversSociety.MyApplication.customers.Customer;
import com.AnimalLoversSociety.MyApplication.items.Items;
import com.AnimalLoversSociety.MyApplication.items.ItemsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CartController {
    private final CartService cartService;
    private final ItemsController itemsController;

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
    public String addItemToCart(@PathVariable long id, @ModelAttribute("item") Items item, Model model, RedirectAttributes redirectAttributes) {
        cartService.addItem(itemsController.getItemById(id));
        redirectAttributes.addFlashAttribute("message", "Success");
        return "redirect:/shop";
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
        Customer customerToDb = cartService.saveCustomerInfo(customer);
        cartService.updateInventory();
        cartService.saveToSales(customerToDb);
        cartService.deleteCart();
        return "redirect:/shop";
    }
}
