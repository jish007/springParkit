package com.carparking.project.domain;

public class PropertyImage {

    private String image;
    private String propertyLocation;
    private String propertyName;

    // Default constructor
    public PropertyImage() {}

    public PropertyImage(String image, String propertyLocation, String propertyName) {
        this.image = image;
        this.propertyLocation = propertyLocation;
        this.propertyName = propertyName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String toString() {
        return "PropertyImageDto{" +
                "image='" + image + '\'' +
                ", propertyLocation='" + propertyLocation + '\'' +
                ", propertyName='" + propertyName + '\'' +
                '}';
    }
}
