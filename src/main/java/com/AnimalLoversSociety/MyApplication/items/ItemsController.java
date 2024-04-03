package com.AnimalLoversSociety.MyApplication.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ItemsController {

    @Autowired
    private ItemsRepository itemRepo;

    // Loads the item to the create item page
    @GetMapping("/items/create")
    public String showItemCreateForm(Model model) {
        model.addAttribute("item", new Items());
        return "items_create";
    }

    // directs to the items homepage
    @GetMapping("/items")
    public String viewItemsPage() {
        return "/items";
    }

    //saves the item as an item, shirt, or sculpture based on the form parameters
    @PostMapping("/items")
    public String saveItem(
            @ModelAttribute("items") Items item,
            @RequestParam(value = "productType") String productType,
            @RequestParam(value = "shirtSize", required = false) String shirtSize,
            @RequestParam(value = "shirtColour", required = false) String shirtColour,
            @RequestParam(value = "sculptureWeight", required = false) String sculptureWeight,
            @RequestParam(value = "sculptureHeight", required = false) String sculptureHeight
    ) {
        if ("Shirts".equals(productType)) {
            Shirts shirt = new Shirts(item.getName(), item.getSalePrice(), item.getCost(), item.getInventory(),
                    shirtColour, shirtSize);
            shirt.setProfit(item.getSalePrice() - item.getCost());
            shirt.setImageUrl(item.getImageUrl());
            itemRepo.save(shirt);
        } else if ("Sculptures".equals(productType)) {
            double weight = Double.parseDouble(sculptureWeight);
            double height = Double.parseDouble(sculptureHeight);
            Sculptures sculpture = new Sculptures(item.getName(), item.getSalePrice(), item.getCost(), item.getInventory(),
                    weight, height);
            sculpture.setProfit(item.getSalePrice() - item.getCost());
            sculpture.setImageUrl(item.getImageUrl());
            itemRepo.save(sculpture);
        } else {
            item.setProfit(item.getSalePrice() - item.getCost());
            item.setImageUrl(item.getImageUrl());
            itemRepo.save(item);
        }
        return "redirect:/items/manage";
    }

    // Will show all the entries in the items table
    @GetMapping(path = "/items/inventory")
    public String allItems(Model model) {

        model.addAttribute("items", itemRepo.findAll());
        return "inventory"; // return the name of the view
    }

    //Loads the items to the manage items page
    @GetMapping(path = "/items/manage")
    public String showManageItemPage(Model model) {
        model.addAttribute("items", itemRepo.findAll());
        return "items_manage";
    }

    //loads a single item to the edit item page based on the path variable
    @GetMapping(path = "/items/edit/{itemId}")
    public String showEditItemPage(@PathVariable String itemId, Model model) {
        long id = Long.parseLong(itemId);
        model.addAttribute("items", itemRepo.findById(id).get());
        return "items_edit";
    }

    // Deletes a specific item
    @GetMapping(path = "/items/delete/{itemId}")
    public String deleteItem(@PathVariable String itemId) {
        long id = Long.parseLong(itemId);
        itemRepo.deleteById(id);
        return "redirect:/items/manage";
    }

    //Loads a specific item based on the item number and saves the item depending on if it's an item or one of its subclasses
    @PostMapping("/items/edit/{itemId}")
    public String editItem(@PathVariable String itemId,
                           @ModelAttribute("item") Items item,
                           @RequestParam(value = "shirtSize", required = false) String shirtSize,
                           @RequestParam(value = "shirtColour", required = false) String shirtColour,
                           @RequestParam(value = "sculptureWeight", required = false) String sculptureWeight,
                           @RequestParam(value = "sculptureHeight", required = false) String sculptureHeight
    ) {
        long id = Long.parseLong(itemId);
        Items existingItem = itemRepo.findById(id).get();

        if ("Shirt".equals(existingItem.getItemType())) {
            Shirts existingShirt = (Shirts) existingItem;
            existingShirt.setId(id);
            existingShirt.setName(item.getName());
            existingShirt.setItemType(item.getItemType());
            existingShirt.setSalePrice(item.getSalePrice());
            existingShirt.setCost(item.getCost());
            existingShirt.setInventory(item.getInventory());
            existingShirt.setProfit(item.getSalePrice() - item.getCost());
            existingShirt.setColour(shirtColour);
            existingShirt.setSize(shirtSize);
            existingShirt.setImageUrl(item.getImageUrl());
            itemRepo.save(existingShirt);
        } else if ("Sculpture".equals(existingItem.getItemType())) {
            double weight = Double.parseDouble(sculptureWeight);
            double height = Double.parseDouble(sculptureHeight);
            Sculptures existingSculpture = (Sculptures) existingItem;
            existingSculpture.setId(id);
            existingSculpture.setName(item.getName());
            existingSculpture.setItemType(item.getItemType());
            existingSculpture.setSalePrice(item.getSalePrice());
            existingSculpture.setCost(item.getCost());
            existingSculpture.setInventory(item.getInventory());
            existingSculpture.setProfit(item.getSalePrice() - item.getCost());
            existingSculpture.setHeight(height);
            existingSculpture.setWeight(weight);
            existingSculpture.setImageUrl(item.getImageUrl());
            itemRepo.save(existingSculpture);
        } else {
            existingItem.setId(id);
            existingItem.setName(item.getName());
            existingItem.setItemType(item.getItemType());
            existingItem.setSalePrice(item.getSalePrice());
            existingItem.setCost(item.getCost());
            existingItem.setInventory(item.getInventory());
            existingItem.setProfit(item.getSalePrice() - item.getCost());
            existingItem.setImageUrl(item.getImageUrl());
            itemRepo.save(existingItem);
        }
        return "redirect:/items/manage";
    }

    // loads specific item to reorder page
    @GetMapping(path = "/items/reorder/{itemId}")
    public String showItemReorderPage(@PathVariable String itemId, Model model) {
        long id = Long.parseLong(itemId);
        model.addAttribute("items", itemRepo.findById(id).get());
        return "items_reorder";
    }

    // posts the reorder info
    @PostMapping("/items/reorder/{itemId}")
    public String reorderItem(@PathVariable String itemId, @ModelAttribute("item") Items item, Model model) {
        long id = Long.parseLong(itemId);
        // Get seminar from database by id
        Items existingItem = itemRepo.findById(id).get();

        // Update the info
        existingItem.setId(id);
        existingItem.setReplenishOrderedDate(new Date());
        existingItem.setReplenishArrivalDate(item.getReplenishArrivalDate());
        existingItem.setInventoryOnReorder(item.getInventoryOnReorder());

        // Save updated seminar object
        itemRepo.save(existingItem);
        return "redirect:/items/inventory";
    }

    // receives the reorder and edits the items inventory
    @GetMapping(path = "/items/reorder/received/{itemId}")
    public String reorderReceived(@PathVariable String itemId) {
        long id = Long.parseLong(itemId);
        Items item = itemRepo.findById(id).get();
        item.setId(id);
        item.setInventory(item.getInventory() + item.getInventoryOnReorder());
        item.setInventoryOnReorder(0);
        item.setReplenishArrivalDate(null);
        item.setReplenishOrderedDate(new Date());

        itemRepo.save(item);
        return "redirect:/items/inventory";
    }

    @GetMapping(path = "/shop")
    public String showItemsShopPage(Model model) {
        model.addAttribute("items", itemRepo.findAll());
        return "items_shop";
    }

    public Items getItemById(long id) {
        return itemRepo.findById(id).get();
    }
}