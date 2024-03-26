package com.AnimalLoversSociety.MyApplication.items;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * inherits from the item class, adds weight and height
 */

@Entity // this turns this object into something that can be entered into a MySql table
@DiscriminatorValue("2") // this is used to differentiate from different objects on the same table
public class Sculptures extends Items {

    private double weight;
    private double height;

    Sculptures(double weight, double height) {
        super(/*1111,*/ "Sculpture", 1111, 1111, 1111);
        this.weight = weight;
        this.height = height;

    }


    public Sculptures() {

    }
}

