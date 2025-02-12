package com.carparking.project.service;

import com.carparking.project.domain.UserDto;
import com.carparking.project.entities.User;
import com.carparking.project.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;


    public String login(UserDto userDto) throws Exception {
        User user =  loginRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword());
        if(Objects.nonNull(user)){
            if (Objects.equals(user.getRoleName(), "ADMIN_USER")){
                user.setActive("ACTIVE");
                loginRepository.save(user);
                return "Admin Is Valid";
            }
            else if(Objects.equals(user.getRoleName(), "SUPER_ADMIN")){
                user.setActive("ACTIVE");
                loginRepository.save(user);
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

    public void updateStatus(String errorcode,String email){
        Optional<User> login =  loginRepository.findById(email);
        login.get().setRemarks(errorcode);
        loginRepository.save(login.get());
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

    public String logout(String emailid){
        Optional<User> login = loginRepository.findById(emailid);
        login.get().setActive("");
        loginRepository.save(login.get());
        return "logout succesfull";
    }

}
