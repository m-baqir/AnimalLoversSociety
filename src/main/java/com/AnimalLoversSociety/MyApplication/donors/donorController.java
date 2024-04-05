package com.AnimalLoversSociety.MyApplication.donors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class donorController {
    @Autowired
    private donorRepository donorRepo;

    @GetMapping(path = "/donors")
    public String donor(Model model) {
        model.addAttribute("donors", donorRepo.findAll());
        return "donors";
    }

    //Add donor
    @GetMapping("/donors/add")
    public String showDonorAdd(Model model) {
        Iterable<donor> donor1 = donorRepo.findAll();
        model.addAttribute("donor", donor1);

        return "donors_add";
    }

    @PostMapping("/donors")
    public String saveItem(@ModelAttribute("donors") donor donor1,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "donation") String donation,
            @RequestParam(value = "name_change", required = false) String name_change,
            @RequestParam(value = "member", required = false) String member) {

                donorRepo.save(donor1);
                return "redirect:/donors";
    }

    //Edit donor
    // @GetMapping("/donors/edit")
    // public String showDonorEdit(Model model) {
    //     Iterable<donor> donor1 = donorRepo.findAll();
    //     model.addAttribute("donor", donor1);
    //     return "donors_edit";
    // }
}
