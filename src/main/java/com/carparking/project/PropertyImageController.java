package com.carparking.project;

import com.carparking.project.domain.PropertyImage;
import com.carparking.project.entities.PropertyImageEntity; // Import the entity class
import com.carparking.project.service.PropertyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-image")
@CrossOrigin("*")
public class PropertyImageController {

    @Autowired
    private PropertyImageService propertyImageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestBody PropertyImage propertyImageDto) {
        String response = propertyImageService.uploadImage(propertyImageDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-property-name")
    public ResponseEntity<List<PropertyImageEntity>> getImagesByPropertyName(@RequestParam String propertyName) {
        List<PropertyImageEntity> images = propertyImageService.getImagesByPropertyName(propertyName);
        return ResponseEntity.ok(images);
    }
}
