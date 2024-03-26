package com.AnimalLoversSociety.MyApplication.donors;

import jakarta.persistence.*;

@Entity
@Table(name = "donors")
public class donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String gender;
    
    @Column()
    private int donation;
    
    @Column()
    private String name_change;
    
    @Column()
    private String member;

    public donor() {
    }

    public donor(String name, String address, String gender, int donation, String name_change, String member) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.donation = donation;
        this.name_change = name_change;
        this.member = member;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getDonation() {
        return donation;
    }
    public void setDonation(int donation) {
        this.donation = donation;
    }

    public String getNameChange() {
        return name_change;
    }
    public void setNameChange(String name_change) {
        this.name_change = name_change;
    }

    public String getMember() {
        return member;
    }
    public void setMember(String member) {
        this.member = member;
    }
}
