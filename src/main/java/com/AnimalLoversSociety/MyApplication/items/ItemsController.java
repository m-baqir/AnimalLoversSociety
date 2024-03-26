package com.AnimalLoversSociety.MyApplication.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ItemsController {

    @Autowired
    private ItemsRepository itemRepo;

    @GetMapping("/items_create")
    public String showItemCreateForm(Model model) {
        model.addAttribute("item", new Items());

        return "items_create";
    }

    @GetMapping("/items")
    public String viewItemsPage() {
        return "/items";
    }

    /*@RequestMapping(value = "/items/add", method = { RequestMethod.POST, RequestMethod.GET })
    public String addNewItem(Items item) {
        item.setItemType(item.getItemType());
        item.setSalePrice(item.getSalePrice());
        item.setCost(item.getCost());
        item.setInventory(item.getInventory());

        itemRepo.save(item);
        return "item_created";
    }*/

    //@GetMapping (path="items/add")
    @RequestMapping(value = "/items/add", method = { RequestMethod.POST, RequestMethod.GET })
    public String showAddItemPage(Items item) {
        item.setItemType(item.getItemType());
        item.setSalePrice(item.getSalePrice());
        item.setCost(item.getCost());
        item.setInventory(item.getInventory());

        itemRepo.save(item);
        return "items_create";
    }

    @PostMapping("/items")
    public String saveItem(@ModelAttribute("items") Items item) {
        itemRepo.save(item);
        return "redirect:/items";
    }

    // http://localhost:8080/items/inventory will show all the entries in the items table
    @GetMapping(path = "/items/inventory")
    public String allItems(Model model) {

        model.addAttribute("items", itemRepo.findAll());
        return "inventory"; // return the name of the view
    }

    @GetMapping(path = "/items/manage")
    public String showManageItemPage(Model model) {
        model.addAttribute("items", itemRepo.findAll());
        return "items_manage";
    }

    @GetMapping(path = "/items/edit/{itemId}")
    public String showEditItemPage(@PathVariable String itemId, Model model) {
        long id = Long.parseLong(itemId);
        model.addAttribute("items", itemRepo.findById(id));
        return "items_edit";
    }

    @PostMapping("/items/edit/{itemId}")
    public String editItem(@PathVariable String itemId, @ModelAttribute("item") Items item, Model model) {
        long id = Long.parseLong(itemId);
        // Get seminar from database by id
        Items existingItem = itemRepo.findById(id).get();

        // Update the info
        existingItem.setId(id);
        existingItem.setItemType(item.getItemType());
        existingItem.setSalePrice(item.getSalePrice());
        existingItem.setCost(item.getCost());
        existingItem.setInventory(item.getInventory());

        // Save updated seminar object
        itemRepo.save(existingItem);
        return "redirect:/items/manage";
    }


}