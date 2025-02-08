package com.carparking.project;

import com.carparking.project.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/super-admin")
@CrossOrigin("*")
public class SuperAdminController {

    @Autowired
    private SuperAdminService superAdminService;

    @GetMapping("get-all-property-details")
    public List<Map<String, Object>> getJoinedData() {
        return superAdminService.getJoinedData();
    }

    @GetMapping("accept-property-details")
    public String mailLoginCredentials(@RequestParam String email) throws Exception {
        return superAdminService.acceptPropertyDetails(email);
    }

    @GetMapping("reject-property-details")
    public String rejectCredentials(@RequestParam String email){
        return superAdminService.rejectPropertyDetails(email);
    }
}

