package com.AnimalLoversSociety.MyApplication.donations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * This program was to just test adding and deleting items on the items table
 */
@Component
public class DonationsDirectToDatabase implements CommandLineRunner {

    @Autowired
    DonationsRepository donationsRepo;

    @Override
    public void run(String... args) throws Exception {
        donationsRepo.saveAll(Arrays.asList(
                new Donations(1, 1, 100, new Date()),
                new Donations(1, 2, 300, new Date()),
                new Donations(2, 3, 200, new Date()),
                new Donations(2, 4, 400, new Date()),
                new Donations(3, 5, 300, new Date()),
                new Donations(3, 6, 500, new Date()),
                new Donations(3, 7, 400, new Date()),
                new Donations(4, 8, 600, new Date()),
                new Donations(5, 9, 500, new Date()),
                new Donations(5, 10, 700, new Date())
        ));
        System.out.println("Donation Data Saved to Database");
        donationsRepo.deleteById(4L);
        System.out.println("Test: deleted 4 from donation table");
    }
}
