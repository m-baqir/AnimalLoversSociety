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

    @GetMapping("/items/create")
    public String showItemCreateForm(Model model) {
        model.addAttribute("item", new Items());

        return "items_create";
    }

    @GetMapping("/items")
    public String viewItemsPage() {
        return "/items";
    }

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

//    @PostMapping("/items")
//    public String saveItem(@ModelAttribute("items") Items item) {
//        item.setProfit(item.getSalePrice() - item.getCost());
//        itemRepo.save(item);
//        return "redirect:/items";
//    }

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
                    shirtSize, shirtColour);
            shirt.setProfit(item.getSalePrice() - item.getCost());
            itemRepo.save(shirt);
        } else if ("Sculptures".equals(productType)) {
            double weight = Double.parseDouble(sculptureWeight);
            double height = Double.parseDouble(sculptureHeight);
            Sculptures sculpture = new Sculptures(item.getName(), item.getSalePrice(), item.getCost(), item.getInventory(),
                    weight, height);
            itemRepo.save(sculpture);
        } else {
            item.setProfit(item.getSalePrice() - item.getCost());
            itemRepo.save(item);
        }
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
        model.addAttribute("items", itemRepo.findById(id).get());
        return "items_edit";
    }

    @GetMapping(path = "/items/delete/{itemId}")
    public String deleteItem(@PathVariable String itemId) {
        long id = Long.parseLong(itemId);
        itemRepo.deleteById(id);
        return "redirect:/items/manage";
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
        existingItem.setProfit(item.getSalePrice() - item.getCost());

        // Save updated seminar object
        itemRepo.save(existingItem);
        return "redirect:/items/manage";
    }

    @GetMapping(path = "/items/reorder/{itemId}")
    public String showItemReorderPage(@PathVariable String itemId, Model model) {
        long id = Long.parseLong(itemId);
        model.addAttribute("items", itemRepo.findById(id).get());
        return "items_reorder";
    }

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