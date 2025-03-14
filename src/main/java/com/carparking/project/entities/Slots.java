package com.carparking.project.entities;

import com.carparking.project.domain.SlotsDto;

import javax.persistence.*;

@Entity
@Table(name = "slots")
public class Slots implements Comparable<Slots>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotId;

    private String slotNumber;
    private String floor;
    private String vehicleType; // Added vehicleType
    private String propertyName;
    private String city;
    private String district;
    private String state;
    private String country;
    private boolean slotAvailability;
    private String googleLocation;
    private String adminName;
    private String adminPhone;
    private String propertyType;
    private String adminMailId;
    private String vehicleNum;
    private Integer x;
    private Integer y;
    private Integer height;
    private Integer width;
    private String ranges;
    private boolean hold;
    private String holdExpiryTime;
    private String startTime;
    private String exitTime;
    private String sheetId;

    // Default constructor
    public Slots() {}

    public Slots(SlotsDto slotsDto, String slotNumber, String floor, String vehicleType) {
        this.slotNumber = slotNumber;
        this.floor = floor;
        this.vehicleType = vehicleType; // Assign vehicleType
        this.propertyName = slotsDto.getPropertyName();
        this.city = slotsDto.getCity();
        this.district = slotsDto.getDistrict();
        this.state = slotsDto.getState();
        this.country = slotsDto.getCountry();
        this.slotAvailability = slotsDto.isSlotAvailability();
        this.googleLocation = slotsDto.getGoogleLocation();
        this.adminName = slotsDto.getAdminName();
        this.adminPhone = slotsDto.getAdminPhone();
        this.propertyType = slotsDto.getPropertyType();
        this.adminMailId = slotsDto.getAdminMailId();
        this.vehicleNum = slotsDto.getVehicleNum();
    }

    // Getters and Setters
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }


    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isSlotAvailability() {
        return slotAvailability;
    }

    public void setSlotAvailability(boolean slotAvailability) {
        this.slotAvailability = slotAvailability;
    }

    public String getGoogleLocation() {
        return googleLocation;
    }

    public void setGoogleLocation(String googleLocation) {
        this.googleLocation = googleLocation;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Slot{" +
                "slotNumber='" + slotNumber + '\'' +
                ", floor='" + floor + '\'' +
                ", vehicleType='" + vehicleType + '\''+
                ", propertyName='" + propertyName + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", slotAvailability=" + slotAvailability +
                ", googleLocation='" + googleLocation + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", adminMailId='" + adminMailId + '\'' +
                ", vehicleNum='" + vehicleNum + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", ranges='" + ranges + '\'' +
                ", hold='" + hold + '\'' +
                ", holdExpiryTime='" + holdExpiryTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", exitTime='" + exitTime + '\'' +
                ", sheetId='" + sheetId + '\'' +
                '}';
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getAdminMailId() {
        return adminMailId;
    }

    public void setAdminMailId(String adminMailId) {
        this.adminMailId = adminMailId;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    @Override
    public int compareTo(Slots other) {
        return this.slotNumber.compareTo(other.slotNumber); // Ascending order
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getRanges() {
        return ranges;
    }

    public void setRanges(String ranges) {
        this.ranges = ranges;
    }

    public boolean isHold() {
        return hold;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public String getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public void setHoldExpiryTime(String holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public String getSheetId() {
        return sheetId;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }
}
