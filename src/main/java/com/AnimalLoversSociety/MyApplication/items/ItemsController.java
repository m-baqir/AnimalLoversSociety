package com.AnimalLoversSociety.MyApplication.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ItemsController {

    @Autowired
    private ItemsRepository itemRepo;

    /*
     * @PostMapping(path="/add")
     * public @ResponseBody String addNewItem (@RequestParam int
     * itemCode, @RequestParam String itemType, @RequestParam double
     * salePrice, @RequestParam double cost, @RequestParam long inventory) {
     * Items n = new Items();
     * n.setId(itemCode);
     * n.setItemType(itemType);
     * n.setSalePrice(salePrice);
     * n.setCost(cost);
     * n.setInventory(inventory);
     * return "Saved";
     * }
     */

    // @PostMapping(path="/add")
    // Test method to entering a url to activate a method to create a new entry to
    // the items table
    // http://localhost:8080/test/{itemCode}/
    @RequestMapping(value = "/test/{itemCode}", method = { RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody String addNewItem(@PathVariable long itemCode) {
        Items n = new Items();
        n.setId(itemCode);
        n.setItemType("TEST");
        n.setSalePrice(88);
        n.setCost(88);
        n.setInventory(888);
        itemRepo.save(n);
        return "Saved";
    }

    // Test method to entering a url to activate a method to delete entry from the
    // items table
    // http://localhost:8080/test/de/{itemCode}/
    @RequestMapping(value = "/test/del/{itemCode}", method = { RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody String removeItem(@PathVariable long itemCode) {
        itemRepo.deleteById(itemCode);
        return "Deleted";
    }

    // http://localhost:8080/all will show all the entries in the items table
    @GetMapping(path = "/allitems")
    public Iterable<Items> getAllItems() {
        return itemRepo.findAll();
    }

    // http://localhost:8080/hi will take you to a blank html page that says hello
    @GetMapping(path = "/hi")
    public String helloWorld() {
        return "Hello";
    }

    // http://localhost:8080/all/{id}/ will show you a specific entry in the items
    // table based on itemCode
    @GetMapping(path = "/allitems/{id}")
    public Optional<Items> show(@PathVariable String id) {
        long itemId = Long.parseLong(id);
        return itemRepo.findById(itemId);
    }
}
