package com.carparking.project.entities;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;

    @Column(nullable = false)
    private String vehicleNumber;

    private String phoneNum;
    private String userName;
    private int noOfVehicles;
    private String vehicleType;
    private String bookingDate;
    private String userEmailId;
    private boolean paidStatus;
    private double paidAmount;
    private String allocatedSlotNumber;
    private String parkedPropertyName;
    private int durationOfAllocation;
    private String paymentDate;
    private String adminMailId;
    private String vehicleModel;
    private double totalAmount;
    private LocalTime bookingTime;
    private boolean isBanned;
    private int fineAmount;

    // Getters and Setters
    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNoOfVehicles() {
        return noOfVehicles;
    }

    public void setNoOfVehicles(int noOfVehicles) {
        this.noOfVehicles = noOfVehicles;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getAllocatedSlotNumber() {
        return allocatedSlotNumber;
    }

    public void setAllocatedSlotNumber(String allocatedSlotNumber) {
        this.allocatedSlotNumber = allocatedSlotNumber;
    }

    public String getParkedPropertyName() {
        return parkedPropertyName;
    }

    public void setParkedPropertyName(String parkedPropertyName) {
        this.parkedPropertyName = parkedPropertyName;
    }

    public int getDurationOfAllocation() {
        return durationOfAllocation;
    }

    public void setDurationOfAllocation(int durationOfAllocation) {
        this.durationOfAllocation = durationOfAllocation;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAdminMailId() {
        return adminMailId;
    }

    public void setAdminMailId(String adminMailId) {
        this.adminMailId = adminMailId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }
}
