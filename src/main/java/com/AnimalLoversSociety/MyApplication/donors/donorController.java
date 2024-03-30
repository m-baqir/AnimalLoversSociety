package com.AnimalLoversSociety.MyApplication.donors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class donorController {
    @Autowired
    private donorRepository donorRepo;

    @GetMapping(path = "/donors")
    public String donor() {
        return "donors";
    }

    //Add donor
    @GetMapping("/donors/add")
    public String showDonorAdd(Model model) {
        Iterable<donor> donor1 = donorRepo.findAll();
        model.addAttribute("donor", donor1);
        return "donors_add";
    }

    //Edit donor
    @GetMapping("/donors/edit")
    public String showDonorEdit(Model model) {
        Iterable<donor> donor1 = donorRepo.findAll();
        model.addAttribute("donor", donor1);
        return "donors_edit";
    }
}
