package com.carparking.project.service;

import com.carparking.project.domain.ProfileDto;
import com.carparking.project.entities.Profile;
import com.carparking.project.entities.PropertyImageEntity;
import com.carparking.project.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public String saveProfile(ProfileDto profileDto) {
        Profile entity = new Profile();
        entity.setVehicleNumber(profileDto.getVehicleNumber());
        entity.setPhoneNum(profileDto.getPhoneNum());
        entity.setUserName(profileDto.getUserName());
        entity.setNoOfVehicles(profileDto.getNoOfVehicles());
        entity.setVehicleType(profileDto.getVehicleType());
        entity.setBookingDate(profileDto.getBookingDate());
        entity.setUserEmailId(profileDto.getUserEmailId());
        entity.setPaidStatus(profileDto.isPaidStatus());
        entity.setPaidAmount(profileDto.getPaidAmount());
        entity.setAllocatedSlotNumber(profileDto.getAllocatedSlotNumber());
        entity.setParkedPropertyName(profileDto.getParkedPropertyName());
        entity.setDurationOfAllocation(profileDto.getDurationOfAllocation());
        entity.setPaymentDate(profileDto.getPaymentDate());
        entity.setAdminMailId(profileDto.getAdminMailId());
        entity.setVehicleModel(profileDto.getVehicleModel());
        entity.setTotalAmount(profileDto.getTotalAmount());
        entity.setBookingTime(profileDto.getBookingTime());

        profileRepository.save(entity);
        return "Profile saved successfully!";
    }

    public List<ProfileDto> getProfilesByAdminMailId(String adminMailId) {
        return profileRepository.findByAdminMailId(adminMailId).stream().map(entity -> {
            ProfileDto profileDto = new ProfileDto();
            profileDto.setVehicleNumber(entity.getVehicleNumber());
            profileDto.setPhoneNum(entity.getPhoneNum());
            profileDto.setUserName(entity.getUserName());
            profileDto.setNoOfVehicles(entity.getNoOfVehicles());
            profileDto.setVehicleType(entity.getVehicleType());
            profileDto.setBookingDate(entity.getBookingDate());
            profileDto.setUserEmailId(entity.getUserEmailId());
            profileDto.setPaidStatus(entity.isPaidStatus());
            profileDto.setPaidAmount(entity.getPaidAmount());
            profileDto.setAllocatedSlotNumber(entity.getAllocatedSlotNumber());
            profileDto.setParkedPropertyName(entity.getParkedPropertyName());
            profileDto.setDurationOfAllocation(entity.getDurationOfAllocation());
            profileDto.setPaymentDate(entity.getPaymentDate());
            profileDto.setProfileId(entity.getProfileId());
            profileDto.setAdminMailId(entity.getAdminMailId());
            profileDto.setVehicleModel(entity.getVehicleModel());
            profileDto.setTotalAmount(entity.getTotalAmount());
            profileDto.setBookingTime(entity.getBookingTime());
            profileDto.setBanned(entity.isBanned());
            profileDto.setFineAmount(entity.getFineAmount());
            return profileDto;
        }).collect(Collectors.toList());
    }

    public List<Profile> getProfileByVehicleNumber(String vehicleNumber) {
        return profileRepository.findByVehicleNumber(vehicleNumber);
    }
}
