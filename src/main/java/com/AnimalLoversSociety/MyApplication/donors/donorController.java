package com.AnimalLoversSociety.MyApplication.donors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class donorController {
    @PostMapping(path="/donors")

    @GetMapping(path = "/donors")
    @RequestMapping(path = "donors")
    public String donor() {
        return "Donors";
    }
}
