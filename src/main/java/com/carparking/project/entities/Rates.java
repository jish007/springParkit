package com.carparking.project.entities;

import com.carparking.project.domain.RatesDto;

import javax.persistence.*;

@Entity
@Table(name="rates")
public class Rates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String googleLocation;
    private Double duration;
    private Double charge;
    private String adminMailId;

    // Constructors
    public Rates() {}

    public Rates(RatesDto ratesDto,String emailId) {
        this.googleLocation = ratesDto.getGoogleLocation();
        this.duration = ratesDto.getDuration();
        this.charge = ratesDto.getCharge();
        this.adminMailId = emailId;
    }

    // Getters and Setters
    public String getGoogleLocation() {
        return googleLocation;
    }

    public void setGoogleLocation(String googleLocation) {
        this.googleLocation = googleLocation;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    // toString method
    @Override
    public String toString() {
        return "Rate{" +
                "googleLocation='" + googleLocation + '\'' +
                ", duration=" + duration +
                ", charge=" + charge +
                '}';
    }

    public String getAdminMailId() {
        return adminMailId;
    }

    public void setAdminMailId(String adminMailId) {
        this.adminMailId = adminMailId;
    }
}
