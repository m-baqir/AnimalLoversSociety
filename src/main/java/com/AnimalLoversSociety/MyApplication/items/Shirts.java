package com.AnimalLoversSociety.MyApplication.items;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * inherits from the Items class, adds colour and size
 */

@Entity
@DiscriminatorValue("1")
public class Shirts extends Items {


    private String colour;
    private String size;


    Shirts(String name, double salePrice, double cost, long inventory, String colour, String size) {
        super(name, "Shirt", salePrice, cost, inventory);
        this.colour = colour;
        this.size = size;

    }


    public Shirts() {

    }

    @Override
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
