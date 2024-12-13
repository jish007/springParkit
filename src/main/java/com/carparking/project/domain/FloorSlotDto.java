package com.carparking.project.domain;

import java.util.List;

public class FloorSlotDto {
    private List<String> slotNumber;
    private String floor;
    private List<String> vehicleType; // Added vehicleType

    public FloorSlotDto(List<String> slotNumber, String floor, List<String> vehicleType) {
        this.slotNumber = slotNumber;
        this.floor = floor;
        this.vehicleType = vehicleType;
    }

    public List<String> getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(List<String> slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public List<String> getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(List<String> vehicleType) {
        this.vehicleType = vehicleType;
    }
}
