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

    Shirts(String colour, String size) {
        super(/*4312,*/ "Shirt", 1234, 1234, 1234);
        this.colour = colour;
        this.size = size;

    }


    public Shirts() {

    }
}
