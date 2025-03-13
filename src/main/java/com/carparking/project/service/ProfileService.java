package com.carparking.project.service;

import com.carparking.project.domain.*;
import com.carparking.project.entities.Profile;
import com.carparking.project.entities.Slots;
import com.carparking.project.entities.User;
import com.carparking.project.helper.JotFormSubmissions;
import com.carparking.project.repository.LoginRepository;
import com.carparking.project.repository.ProfileRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    JotFormSubmissions jotFormSubmissions;

    @Autowired
    LoginService loginService;

    @Autowired
    ObjectMapper objectMapper;


    //for app users
    public String saveProfile(ProfileDto profileDto) throws Exception{
        Profile entity = new Profile();
        entity.setVehicleNumber(profileDto.getVehicleNumber());
        entity.setUserName(profileDto.getUserName());
        entity.setUserEmailId(profileDto.getUserEmailId());
        entity.setVehicleModel(profileDto.getVehicleModel());
        entity.setVehicleBrand(profileDto.getVehicleBrand());
        entity.setVehicleClr(profileDto.getVehicleClr());
        entity.setFuelType(profileDto.getFuelType());
        entity.setVehicleGene(profileDto.getVehicleGene());
        entity.setVehicleType(profileDto.getVehicleType());
        entity.setPhoneNum(profileDto.getPhoneNum());
        entity.setNoOfVehicles(1);
        entity.setPaidStatus(false);
        entity.setPaidAmount((double) 0);
        entity.setTotalAmount((double) 0);
        entity.setBanned(false);
        entity.setFineAmount((double) 0);


        UserDto userDto = new UserDto();
        userDto.setEmail(profileDto.getUserEmailId());
        userDto.setPassword(profileDto.getPassword());
        userDto.setRoleName("USER");
        userDto.setActive("INACTIVE");

        User user = loginRepository.save(new User(userDto));
        Profile profile = profileRepository.save(entity);
        if(Objects.nonNull(user) && Objects.nonNull(profile)){
            return "User Is Created";
        }
        else{
            throw new Exception("User Creation Failed");
        }
    }

    //for on-site users
    public void saveOnSiteProfile(String vehicleNumber, Slots slots, String bookingSource) throws Exception{
        Profile profile = new Profile();
        profile.setVehicleNumber(vehicleNumber);
        profile.setAllocatedSlotNumber(slots.getSlotNumber());
        profile.setBookingSource(bookingSource);
        profile.setVehicleType("car");
        profile.setBookingDate(LocalDateTime.now().toString());
        profile.setDurationOfAllocation("01:00:00");
        profile.setParkedPropertyName(slots.getPropertyName());
        profile.setAdminMailId(slots.getAdminMailId());
        profile.setNoOfVehicles(1);
        profile.setPaidStatus(false);
        profile.setPaidAmount((double) 0);
        profile.setTotalAmount((double) 0);
        profile.setBookingTime(LocalDateTime.now().toLocalTime().toString());
        profile.setBanned(false);
        profile.setFineAmount((double) 0);
        Profile obj = profileRepository.save(profile);
        if (Objects.nonNull(obj)){
            System.out.println("On site profile created");
        }
        else {
            throw new Exception("On-Site profile creation failed");
        }
    }

    public List<Profile> getProfilesByAdminMailId(String adminMailId) {
        return profileRepository.findByAdminMailId(adminMailId);
    }

    public Profile getProfileByVehicleNumber(String vehicleNumber) {
        return profileRepository.findByVehicleNumber(vehicleNumber);
    }

    public List<Profile> getProfiles(){
        List<Profile> list = new ArrayList<>();
        profileRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }



    public  String updateProfile(String formId) throws JsonProcessingException {
        String jsonResponse =   jotFormSubmissions.getFormResponse(formId);
        JsonResponse jsonResponse1 =objectMapper.readValue(jsonResponse, JsonResponse.class);
        List<FormContent> formdata = jsonResponse1.getContent();
        Map<String, Answer> answers =   formdata.stream().map(form->form.getAnswers()).findFirst().get();
        Answer vehicleData = answers.get("5");
        Answer email = answers.get("4");
        Answer fullName = answers.get("3");

        System.out.println(answers);
        String vehiclenumber = vehicleData.getAnswer().toString().replaceAll("\\s","");
        String emailData =email.getAnswer().toString().replaceAll("\\s","");
        String fullNamePrettyFormat = fullName.getPrettyFormat();
        ;        String emailinfo = emailData.replace("\"", "");  // Remove all double quotes
        String output = vehiclenumber.replace("\"", "");  // Remove all double quotes
        try {
            List<Profile> profiles = new ArrayList<>();
            profileRepository.findAll().forEach(profiles::add);
            Profile profile =   profiles.stream().filter(p->p.getVehicleNumber().equals(output.toLowerCase())).collect(Collectors.toList()).get(0);
            System.out.println(profile);
            profile.setUserEmailId(emailinfo);
            profile.setUserName(fullNamePrettyFormat);
            profileRepository.save(profile);
            UserDto userDto =new UserDto();
            userDto.setEmail(emailinfo);
            userDto.setRoleName("USER");
            userDto.setPassword(String.valueOf(Math.random())+"xxxx");
            userDto.setActive("");
            loginService.signUp(userDto,"USER");
        }
        catch (Exception e){
            System.out.println("e==="+e.getMessage());

        }
        return  null;
    }

}
