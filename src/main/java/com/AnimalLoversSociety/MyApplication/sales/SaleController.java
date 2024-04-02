package com.AnimalLoversSociety.MyApplication.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService; }

    @GetMapping("/sales")
    public String getSales(Model model) {
        model.addAttribute("sales", saleService.getSales());
        return "sales";
    }
}
