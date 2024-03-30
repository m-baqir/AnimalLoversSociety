package com.AnimalLoversSociety.MyApplication.items;

import com.AnimalLoversSociety.MyApplication.sales.Sale;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity // turns object into something that can be used with sql table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // makes all inherited objects added to the same table
@DiscriminatorColumn(name="product_type", discriminatorType = DiscriminatorType.INTEGER) // differentiate different objects by int
@DiscriminatorValue("0") // int differentiator
@Table(name = "items") // looks for items table, if doesn't exist it creates it to the database
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //- this is supposed to autogenerate a number everytime object is created, but was having trouble getting to work
    public long id;

    @Column(nullable = false) // sets the item_type column to not nullable
    private String itemType;

    @Column(nullable = false)
    private double salePrice;

    @Column // automatically creates a cost column in the items table
    private double cost;

    @Column(nullable = false)
    private long inventory;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date replenishOrderedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date replenishArrivalDate;

    @Column
    private long inventoryOnReorder;



    @Column
    private double profit;

    @Column
    private String name;

    @OneToMany(mappedBy = "item")
    private List<Sale> sales;

    public Items() {
    }

    //specific constructor
    public Items(String name, String itemType, double salePrice, double cost, long inventory) {
        this.name = name;
        this.itemType = itemType;
        this.salePrice = salePrice;
        this.cost = cost;
        this.inventory = inventory;
        profit = salePrice - cost;
        replenishArrivalDate = null;
        replenishOrderedDate = new Date();
        inventoryOnReorder = 0;
    }

    //setters and getters for items
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public Date getReplenishOrderedDate() {
        return replenishOrderedDate;
    }

    public void setReplenishOrderedDate(Date replenishOrderedDate) {
        this.replenishOrderedDate = replenishOrderedDate;
    }

    public Date getReplenishArrivalDate() {
        return replenishArrivalDate;
    }

    public void setReplenishArrivalDate(Date replenishArrivalDate) {
        this.replenishArrivalDate = replenishArrivalDate;
    }

    public long getInventoryOnReorder() {
        return inventoryOnReorder;
    }

    public void setInventoryOnReorder(long inventoryOnReorder) {
        this.inventoryOnReorder = inventoryOnReorder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
