package com.AnimalLoversSociety.MyApplication.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @PostMapping
    public void addSale(@RequestBody Sale sale) {
        saleService.saveSale(sale);
    }

    @DeleteMapping(path = "{saleId}")
    public void deleteSale(@PathVariable("saleId") Integer saleId) {
        saleService.deleteSale(saleId);
    }
}
