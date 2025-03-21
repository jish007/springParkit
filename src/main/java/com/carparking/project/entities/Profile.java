package com.carparking.project.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @Column(name="vehicle_number")
    private String vehicleNumber;

    private Integer remainingtime;
    private String phoneNum;
    private String userName;
    private Integer noOfVehicles;
    private String vehicleType;
    private String bookingDate;
    private String userEmailId;
    private Boolean paidStatus;
    private Double paidAmount;
    private String allocatedSlotNumber;
    private String parkedPropertyName;
    private String durationOfAllocation;
    private String paymentDate;

    @Override
    public String toString() {
        return "Profile{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", remainingtime=" + remainingtime +
                ", phoneNum='" + phoneNum + '\'' +
                ", userName='" + userName + '\'' +
                ", noOfVehicles=" + noOfVehicles +
                ", vehicleType='" + vehicleType + '\'' +
                ", bookingDate=" + bookingDate +
                ", userEmailId='" + userEmailId + '\'' +
                ", paidStatus=" + paidStatus +
                ", paidAmount=" + paidAmount +
                ", allocatedSlotNumber='" + allocatedSlotNumber + '\'' +
                ", parkedPropertyName='" + parkedPropertyName + '\'' +
                ", durationOfAllocation='" + durationOfAllocation + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", adminMailId='" + adminMailId + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", totalAmount=" + totalAmount +
                ", bookingTime=" + bookingTime +
                ", isBanned=" + isBanned +
                ", fineAmount=" + fineAmount +
                ", bookingSource='" + bookingSource + '\'' +
                ", endtime=" + endtime +
                '}';
    }

    private String adminMailId;
    private String vehicleModel;
    private Double totalAmount;
    private String bookingTime;
    private Boolean isBanned;
    private Double fineAmount;
    private String bookingSource;
    private String endtime;
    private String roleName;
    private String vehicleBrand;
    private String fuelType;
    private String vehicleClr;
    private String vehicleGene;

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

    public Integer getNoOfVehicles() {
        return noOfVehicles;
    }

    public void setNoOfVehicles(Integer noOfVehicles) {
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

    public Boolean isPaidStatus() {
        return paidStatus;
    }

    public Integer getRemainingtime() {
        return remainingtime;
    }

    public void setRemainingtime(Integer remainingtime) {
        this.remainingtime = remainingtime;
    }

    public void setPaidStatus(Boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    public Boolean getPaidStatus() {
        return paidStatus;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
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

    public String getDurationOfAllocation() {
        return durationOfAllocation;
    }

    public void setDurationOfAllocation(String durationOfAllocation) {
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Boolean isBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(String bookingSource) {
        this.bookingSource = bookingSource;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleClr() {
        return vehicleClr;
    }

    public void setVehicleClr(String vehicleClr) {
        this.vehicleClr = vehicleClr;
    }

    public String getVehicleGene() {
        return vehicleGene;
    }

    public void setVehicleGene(String vehicleGene) {
        this.vehicleGene = vehicleGene;
    }
}
