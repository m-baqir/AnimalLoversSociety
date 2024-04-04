package com.AnimalLoversSociety.MyApplication.items;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * inherits from the item class, adds weight and height
 */

@Entity // this turns this object into something that can be entered into a MySql table
@DiscriminatorValue("2") // this is used to differentiate from different objects on the same table
public class Sculptures extends Items {

    private Double weight;
    private Double height;

    Sculptures(String name, double salePrice, double cost, long inventory, double weight, double height) {
        super(name, "Sculpture", salePrice, cost, inventory);
        this.weight = weight;
        this.height = height;
    }

    public Sculptures() {
    }

    //Setter and Getter Methods
    @Override
    public Double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}

