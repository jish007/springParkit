package com.carparking.project.service;

import com.carparking.project.domain.UserDto;
import com.carparking.project.entities.User;
import com.carparking.project.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;


    public String login(UserDto userDto) throws Exception {
        User user =  loginRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword());
        if(Objects.nonNull(user)){
            if (Objects.equals(user.getRoleName(), "ADMIN_USER")){
                return "Admin Is Valid";
            }
            else if(Objects.equals(user.getRoleName(), "USER")){
                return "User Is Valid";
            }
            else if(Objects.equals(user.getRoleName(), "SUPER_ADMIN")){
                return "Super Admin Is Valid";
            }
            else {
                return "Invalid Credential";
            }
        }
        else{
            throw new Exception("Invalid Credential");
        }
    }

    public String signUp(UserDto userDto, String ADMIN_USER) throws Exception {
        userDto.setRoleName(ADMIN_USER);
        User user = loginRepository.save(new User(userDto));
        if(Objects.nonNull(user)){
            return "Admin User Is Created";
        }
        else{
            throw new Exception("Operation Failed");
        }
    }

}
