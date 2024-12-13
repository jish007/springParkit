package com.carparking.project.service;

import com.carparking.project.domain.PropertyImage;
import com.carparking.project.entities.PropertyImageEntity;
import com.carparking.project.repository.PropertyImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyImageService {

    @Autowired
    private PropertyImageRepository propertyImageRepository;

    public String uploadImage(PropertyImage propertyImageDto) {
        PropertyImageEntity propertyImageEntity = new PropertyImageEntity();
        propertyImageEntity.setImage(propertyImageDto.getImage());
        propertyImageEntity.setPropertyLocation(propertyImageDto.getPropertyLocation());
        propertyImageEntity.setPropertyName(propertyImageDto.getPropertyName());
        propertyImageRepository.save(propertyImageEntity);
        return "Image uploaded successfully!";
    }

    public List<PropertyImageEntity> getImagesByPropertyName(String propertyName) {
        return propertyImageRepository.findByPropertyName(propertyName);
    }
}
