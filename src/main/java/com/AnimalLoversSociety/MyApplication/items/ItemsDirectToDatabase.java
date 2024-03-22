package com.AnimalLoversSociety.MyApplication.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * This program was to just test adding and deleting items on the items table
 */

@Component
public class ItemsDirectToDatabase implements CommandLineRunner {

    // required to save and delete entries to the table
    @Autowired
    ItemsRepository itemsRepo;

    // I believe this changes the run method in the main application so that
    // everytime you start the program this is run
    @Override
    public void run(String... args) throws Exception {

        // saves all the below entries into the items table
        itemsRepo.saveAll(Arrays.asList(
                new Items(101, "book", 15, 12, 600),
                new Items(102, "book", 16, 13, 300),
                new Items(103, "video", 25, 15, 100),
                new Items(104, "video", 24, 14, 125),
                new Items(105, "tape", 20, 15, 75),
                new Items(106, "tape", 19, 14, 50),
                new Items(111, "bumper sticker", 5, 1, 800),
                new Items(112, "bumper sticker", 6, 1.5, 1000),
                // enters a shirt object to the items table
                new Shirts("Blue", "XL"),
                // enters a sculptures object to the items table
                new Sculptures(1000, 50)));
        System.out.println("DATA SAVED TO DATABASE");

        // deletes item with itemCode 112 from the items table
        // itemsRepo.deleteById(112L);

    }

}