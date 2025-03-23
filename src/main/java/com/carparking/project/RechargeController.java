package com.carparking.project;

import com.carparking.project.domain.RechargeRequest;
import com.carparking.project.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RechargeController {


    @Autowired
    ProfileService profileService;



    @PostMapping("/recharge")
    public ResponseEntity<String> recharge(@RequestBody RechargeRequest rechargeRequest){
    return ResponseEntity.ok(profileService.rechargeProfile(rechargeRequest.getVehicleNumber(),rechargeRequest.getDuration()));
    }







}
