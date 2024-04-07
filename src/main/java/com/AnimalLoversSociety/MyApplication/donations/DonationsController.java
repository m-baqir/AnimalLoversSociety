package com.AnimalLoversSociety.MyApplication.donations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class DonationsController {

    @Autowired
    private DonationsRepository donationsRepo;

    @GetMapping(path = "/donations")
    public String donor(Model model) {
        model.addAttribute("donations", donationsRepo.findAll());
        return "donations";
    }
    

    //Add
    @GetMapping("/donation/add")
    public String showDonationsAdd(Model model) {
        Iterable<Donations> donations1 = donationsRepo.findAll();
        model.addAttribute("donations", donations1);
        return "donations_add";
    }

    @PostMapping("/donations")
    public String saveItem(@ModelAttribute("donation") Donations donation1,
            @RequestParam(value = "id") long donorID,
            @RequestParam(value = "amount") String donationAmount,
            @RequestParam(value = "date") String date) {
                donationsRepo.save(donation1);
                return "redirect:/donations";
    }

    @GetMapping(path="/donations/all")
    public Iterable<Donations> getAllDonations() { return donationsRepo.findAll(); }

    // @GetMapping(path="/donations/all/{id}")
    // public Optional<Donations> show(@PathVariable String id) {
    //     long donationId = Long.parseLong(id);
    //     // return donationsRepo.findById(/*(int)*/ donationId);
    // }

    //Delete method is not working for some reason
    @RequestMapping(value = "/donations/del/{donationId}", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody String removeDonations(@PathVariable long donationId) {
        // donationsRepo.deleteById((int) 0L);

        return "Deleted";
    }

    @RequestMapping(value = "/donations/{donationId}", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody String addNewDonation(@PathVariable long donationId) {
        Donations n = new Donations();
        n.setDonationAmount(666.66);
        n.setDate(new Date());
        n.setDonationID(donationId);
        n.setDonorID(1111);
        donationsRepo.save(n);
        return "Saved Donation";
    }

    @GetMapping(path="/donations/test")
    public String testString() { return "THIS IS A TEST FROM DONATIONS"; }


}


