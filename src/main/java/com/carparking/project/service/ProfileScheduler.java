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

    @Scheduled(fixedRate = 1000)
    public void updateProfile() throws JsonProcessingException {
    System.out.println("updation from qr code started");
       List<Profile> profiles =  profileService.getProfiles();
       Map<String,String> sheetmap=  slotsService.getAllSlots(slotsService.getActiveUser()).stream().collect(Collectors.toMap(Slots::getSlotNumber,Slots::getSheetId));
        System.out.println(sheetmap);
        List<String> slotsallocated =  profiles.stream().map(p->p.getAllocatedSlotNumber()).collect(Collectors.toList());
        System.out.println(slotsallocated);
        slotsallocated.stream().forEach(slotsallocate-> {
           try {
                profileService.updateProfile(sheetmap.get(slotsallocate));
           } catch (JsonProcessingException e) {
               e.printStackTrace();
           } catch (Exception e) {
               e.printStackTrace();
           }
       });

    }
    @Scheduled(fixedRate = 2000)
public void leaveSlot(){
      Map<String,String> profileWithTimer =   profileService.getAllTimer();
        for (Map.Entry<String, String> entry : profileWithTimer.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            String[] parts =  entry.getValue().split("\\D+");

          if(parts[0].equals("0")&& parts[1].equals("0")&&parts[2].equals("0")){
              System.out.println("parking completed");
             Profile profile =  profileService.getProfileByVehicleNumber(entry.getKey());
        String slotnumber = profile.getAllocatedSlotNumber();
              profileService.leaveSlotFlow(profile, slotnumber);
          }
        }

    }

}
