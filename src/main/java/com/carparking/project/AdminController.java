package com.carparking.project;

import com.carparking.project.domain.UserDto;
import com.carparking.project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
   private LoginService adminService;

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(adminService.login(userDto));
    }
}
