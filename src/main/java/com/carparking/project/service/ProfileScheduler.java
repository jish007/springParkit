package com.carparking.project.service;

import com.carparking.project.entities.Profile;
import com.carparking.project.entities.Slots;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProfileScheduler {

    @Autowired
    ProfileService profileService;

    @Autowired
    SlotsService slotsService;

    @Scheduled(cron = "0 10 * * * ?")
    public void updateProfile() throws JsonProcessingException {
    System.out.println("updation from qr code started");
       List<Profile> profiles =  profileService.getProfiles();
       Map<String,String> sheetmap=  slotsService.getAllSlots(slotsService.getActiveUser()).stream().collect(Collectors.toMap(Slots::getSlotNumber,Slots::getSheetId));
       List<String> slotsallocated =  profiles.stream().map(p->p.getAllocatedSlotNumber()).collect(Collectors.toList());
       slotsallocated.stream().forEach(slotsallocate-> {
           try {
                profileService.updateProfile(sheetmap.get(slotsallocate));
           } catch (JsonProcessingException e) {
               e.printStackTrace();
           }
       });

    }
}
