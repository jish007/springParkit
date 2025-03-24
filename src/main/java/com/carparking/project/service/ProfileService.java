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

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    @Autowired
    SlotsService slotsService;


    //for app users
    public String saveProfile(ProfileDto profileDto) throws Exception {
        Profile entity = new Profile();
        entity.setVehicleNumber(profileDto.getVehicleNumber());
        entity.setUserName(profileDto.getUserName());
        entity.setUserEmailId(profileDto.getUserEmailId());
        entity.setBookingDate(LocalDateTime.now().toString());
        entity.setBookingTime(LocalDateTime.now().toLocalTime().toString());
        entity.setEndtime(LocalDateTime.now().plusHours(1).toLocalTime().toString());
        entity.setDurationOfAllocation("01:00:00");
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
        entity.setAdminMailId(loginRepository.getActiveUser());
        Profile profile = profileRepository.save(entity);
        if (Objects.nonNull(profile)) {
            return "profile Is Created";
        } else {
            throw new Exception("profile Creation Failed");
        }
    }

    //for on-site users
    public void saveOnSiteProfile(String vehicleNumber, Slots slots, String bookingSource) throws Exception {
        Profile profile = new Profile();
        profile.setVehicleNumber(vehicleNumber);
        profile.setAllocatedSlotNumber(slots.getSlotNumber());
        profile.setBookingSource(bookingSource);
        profile.setVehicleType("car");
        profile.setBookingDate(LocalDateTime.now().toString());
        profile.setDurationOfAllocation("01:00:00");
        profile.setParkedPropertyName(slots.getPropertyName());
        profile.setAdminMailId(slots.getAdminMailId());
        profile.setEndtime(LocalDateTime.now().plusHours(1).toLocalTime().toString());
        profile.setNoOfVehicles(1);
        profile.setPaidStatus(false);
        profile.setPaidAmount((double) 0);
        profile.setTotalAmount((double) 0);
        profile.setBookingTime(LocalDateTime.now().toLocalTime().toString());
        profile.setBanned(false);
        profile.setFineAmount((double) 0);
        Profile obj = profileRepository.save(profile);
        if (Objects.nonNull(obj)) {
            System.out.println("On site profile created");
        } else {
            throw new Exception("On-Site profile creation failed");
        }
    }

    public List<Profile> getProfilesByAdminMailId(String adminMailId) {
        return profileRepository.findByAdminMailId(adminMailId);
    }

    public List<Profile> getProfileByUserEmail(String userEmailId) {
        return profileRepository.findByUserEmailId(userEmailId);
    }

    public Profile getProfileByVehicleNumber(String vehicleNumber) {
        return profileRepository.findByVehicleNumber(vehicleNumber);
    }

    public List<Profile> getProfiles() {
        List<Profile> list = new ArrayList<>();
        profileRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    public String updateProfile(String formId) throws Exception {
        String jsonResponse = jotFormSubmissions.getFormResponse(formId);
        JsonResponse jsonResponse1 = objectMapper.readValue(jsonResponse, JsonResponse.class);
        List<FormContent> formdata = jsonResponse1.getContent();
        Map<String, Answer> answers = formdata.stream().map(form -> form.getAnswers()).findFirst().get();
        Answer vehicleData = answers.get("7");
        Answer email = answers.get("4");
        Answer fullName = answers.get("3");

        System.out.println(answers);
        String vehiclenumber = vehicleData.getAnswer().toString().replaceAll("\\s", "");
        String emailData = email.getAnswer().toString().replaceAll("\\s", "");
        String fullNamePrettyFormat = fullName.getPrettyFormat();
        ;
        String emailinfo = emailData.replace("\"", "");  // Remove all double quotes

        List<String> banned = loginRepository.bannedUsers();
        if (banned.contains(emailinfo)) {
            throw new Exception("user is banned");
        }
        String output = vehiclenumber.replace("\"", "");  // Remove all double quotes
        try {
            List<Profile> profiles = new ArrayList<>();
            profileRepository.findAll().forEach(profiles::add);
            Profile profile = profiles.stream().filter(p -> p.getVehicleNumber().equals(output.toLowerCase())).collect(Collectors.toList()).get(0);
            System.out.println(profile);
            profile.setUserEmailId(emailinfo);
            profile.setUserName(fullNamePrettyFormat);
            profileRepository.save(profile);
            UserDto userDto = new UserDto();
            userDto.setEmail(emailinfo);
            userDto.setRoleName("USER");
            userDto.setPassword(String.valueOf(Math.random()) + "xxxx");
            userDto.setActive("");
            loginService.signUp(userDto, "USER");
        } catch (Exception e) {
            System.out.println("e===" + e.getMessage());

        }
        return null;
    }

    public Map<String, String> getAllTimer() {
        LocalDateTime currentDate = LocalDateTime.now();
        List<Profile> profiles = profileRepository.findAll().stream().filter(p -> p.getAdminMailId().equals("gokulgnair777@gmail.com")).collect(Collectors.toList());
        return profiles.stream()
                .collect(Collectors.toMap(Profile::getVehicleNumber, p -> duration(currentDate, convertToLocalDateTime(LocalDateTime.parse(p.getEndtime(), DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss")).toLocalTime(), currentDate.toLocalDate()))));

    }

    private LocalDateTime convertToLocalDateTime(LocalTime time, LocalDate date) {
        return LocalDateTime.of(date, time);
    }


    public String duration(LocalDateTime currentDateTime, LocalDateTime endDateTime) {
        Duration remainingDuration = Duration.between(currentDateTime, endDateTime);
        long hours = remainingDuration.toHours();
        long minutes = remainingDuration.toMinutes() % 60;
        long seconds = remainingDuration.getSeconds() % 60;
        System.out.println(String.format("%02d hours, %02d minutes, %02d seconds", hours, minutes, seconds));
        return String.format("%02d hours, %02d minutes, %02d seconds", hours, minutes, seconds);
    }


    public String ban(String vehicleNumber) {
        Profile profile = profileRepository.findByVehicleNumber(vehicleNumber);
        User user = loginRepository.findByEmail(profile.getUserEmailId());
        profile.setBanned(true);
        user.setIs_banned(true);
        profile = profileRepository.save(profile);
        if (Objects.nonNull(profile)) {
            return "banned";
        }
        return "failed";
    }


    public String rechargeProfile(String vehiclenumber, String duration) {
        Profile profile = profileRepository.findByVehicleNumber(vehiclenumber);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(profile.getEndtime(), formatter);
        LocalDateTime newDateTime = addCustomDuration(dateTime, duration);
        profile.setEndtime(newDateTime.toString());
        profileRepository.save(profile);
        return newDateTime.toString();
    }






    public static LocalDateTime addCustomDuration(LocalDateTime dateTime, String durationStr) {
        Pattern pattern = Pattern.compile("(\\d+)([hms])"); // Regex to extract hours, minutes, seconds
        Matcher matcher = pattern.matcher(durationStr);

        while (matcher.find()) {
            int value = Integer.parseInt(matcher.group(1));
            String unit = matcher.group(2);

            switch (unit) {
                case "h":
                    dateTime = dateTime.plus(value, ChronoUnit.HOURS);
                    break;
                case "m":
                    dateTime = dateTime.plus(value, ChronoUnit.MINUTES);
                    break;
                case "s":
                    dateTime = dateTime.plus(value, ChronoUnit.SECONDS);
                    break;
            }
        }
        return dateTime;




    }

    public void leaveSlotFlow(Profile profile, String slotnumber){
        slotsService.leaveSlot(slotnumber);
        profile.setAllocatedSlotNumber("");
        profile.setEndtime(String.valueOf(0));
    }

}

