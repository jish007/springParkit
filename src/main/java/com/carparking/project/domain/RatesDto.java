package com.carparking.project.domain;


public class RatesDto {

    private String googleLocation;
    private Double duration;
    private Double charge;
    private String adminMailId;

    // Constructors
    public RatesDto() {}

    public RatesDto(String googleLocation, Double duration, Double charge) {
        this.googleLocation = googleLocation;
        this.duration = duration;
        this.charge = charge;
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

    public String getAdminMailId() {
        return adminMailId;
    }

    public void setAdminMailId(String adminMailId) {
        this.adminMailId = adminMailId;
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
}
