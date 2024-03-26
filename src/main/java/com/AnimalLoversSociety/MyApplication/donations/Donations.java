package com.AnimalLoversSociety.MyApplication.donations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "donations")
public class Donations {

    @Column(name = "donor_ID")
    private long donorID;

    @Column(name = "donation_amount")
    private double donationAmount;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private Date date;

    @Id
    @Column(name = "donation_ID")
    private long donationID;

    public Donations(){

    }



    //Specific donations constructor
    public Donations(long donorID, long donationID, double donationAmount, Date date) {
        this.donorID = donorID;
        this.donationID = donationID;
        this.donationAmount = donationAmount;
        this.date = date;
   }

    public long getDonorID() {
        return donorID;
    }

    public void setDonorID(long donorID) {
        this.donorID = donorID;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getDonationID() {
        return donationID;
    }

    public void setDonationID(long donationID) {
        this.donationID = donationID;
    }
}
