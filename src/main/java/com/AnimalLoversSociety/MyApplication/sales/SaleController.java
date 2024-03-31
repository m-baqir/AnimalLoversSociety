package com.AnimalLoversSociety.MyApplication.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "sales")
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService; }

    @GetMapping
    public List<Sale> getSales() {
        return saleService.getSales();
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
