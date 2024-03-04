package com.AnimalLoversSociety.MyApplication.items;

import jakarta.persistence.*;


@Entity // turns object into something that can be used with sql table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // makes all inherited objects added to the same table
@DiscriminatorColumn(name="product_type", discriminatorType = DiscriminatorType.INTEGER) // differentiate different objects by int
@DiscriminatorValue("0") // int differentiator
@Table(name = "items") // looks for items table, if doesn't exist it creates it to the database
public class Items {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) - this is supposed to autogenerate a number everytime object is created, but was having trouble getting to work
    @Column(name="itemCode") // attaches itemCode variable to item_code column in items table
    private long itemCode;

    @Column(nullable = false) // sets the item_type column to not nullable
    private String itemType;

    @Column(nullable = false)
    private double salePrice;

    @Column // automatically creates a cost column in the items table
    private double cost;

    @Column(nullable = false)
    private long inventory;

    @Column
    private double profit;

    public Items() {
    }

    //test constructor
    public Items(long itemCode) {
        this.itemCode = itemCode;
        itemType = "TEST";
        salePrice = 10000;
        cost = 10000;
        inventory = 1000;

    }

    //specific constructor
    public Items(long itemCode, String itemType, double salePrice, double cost, long inventory) {
        this.itemCode = itemCode;
        this.itemType = itemType;
        this.salePrice = salePrice;
        this.cost = cost;
        this.inventory = inventory;
        this.profit = salePrice - cost;


    }

    //setters and getters for items
    public void setId(long itemCode) {
        this.itemCode = itemCode;
    }

    public long getId() {
        return itemCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }
}
