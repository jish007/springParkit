package com.carparking.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;


public class SlotsDto {


    private List<FloorSlotDto> floorSlotDto;
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
    private LocalDateTime holdExpiryTime;
    private LocalDateTime startTime;
    private LocalDateTime exitTime;
    private String sheetId;

    private UserDto userDto;
    private List<RoleDto> roleDto;
    private List<RatesDto> ratesDto;

    // Default constructor
    public SlotsDto() {}

    public List<FloorSlotDto> getFloorSlotDto() {
        return floorSlotDto;
    }

    public List<RatesDto> getRatesDto() {
        return ratesDto;
    }

    public void setRatesDto(List<RatesDto> ratesDto) {
        this.ratesDto = ratesDto;
    }

    public void setFloorSlotDto(List<FloorSlotDto> floorSlotDto) {
        this.floorSlotDto = floorSlotDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
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

    public List<RoleDto> getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(List<RoleDto> roleDto) {
        this.roleDto = roleDto;
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
    public String toString() {
        return "SlotsDto{" +
                "floorSlotDto=" + floorSlotDto +
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
                ", adminMail='" + adminMailId + '\'' +
                ", vehicleNum='" + vehicleNum + '\'' +
                '}';
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

    public LocalDateTime getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public void setHoldExpiryTime(LocalDateTime holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getSheetId() {
        return sheetId;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }
}
