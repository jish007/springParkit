package com.carparking.project.service;

import com.carparking.project.domain.FloorSlotDto;
import com.carparking.project.domain.SlotsDto;
import com.carparking.project.entities.Slots;
import com.carparking.project.repository.LoginRepository;
import com.carparking.project.repository.SlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class SlotsService {

    @Autowired
    SlotsRepository slotsRepository;

    @Autowired
    LoginService loginService;

    @Autowired
    RatesService ratesService;

    @Autowired
    RoleService roleService;

    @Autowired
    LoginRepository loginRepository;

    public String createSlots(SlotsDto slotsDto) throws Exception {
        Iterable<Slots> slots = slotsRepository.saveAll(getSlots(slotsDto));
        if (slots.iterator().hasNext()) {
            loginService.signUp(slotsDto.getUserDto(), roleService.ADMIN_USER);
            ratesService.saveRates(slotsDto.getRatesDto(), slotsDto.getUserDto().getEmail());
            roleService.stageRoles(slotsDto.getRoleDto(), slotsDto.getUserDto().getEmail());
            return "Slots Added Successfully";
        } else {
            throw new Exception("Slots saving is Failed");
        }
    }

    private List<Slots> getSlots(SlotsDto slotsDto) {
        return slotsDto.getFloorSlotDto().stream()
                .flatMap(fs -> createSlots(slotsDto, fs))
                .collect(Collectors.toList());
    }

    private Stream<Slots> createSlots(SlotsDto slotsDto, FloorSlotDto floorSlotDto) {
        return IntStream.range(0, floorSlotDto.getSlotNumber().size())
                .mapToObj(i -> new Slots(
                        slotsDto,
                        floorSlotDto.getSlotNumber().get(i),
                        floorSlotDto.getFloor(),
                        floorSlotDto.getVehicleType().get(i) // Map vehicleType
                ));
    }

    public List<Slots> getAllSlots(String adminMailId) {
        List<Slots> slots = slotsRepository.findByAdminMailId(adminMailId);
        System.out.println("Slots Data: " + slots);
        return slots;
    }

    public String getActiveUser(){
        return loginRepository.getActiveUser();
    }

    public Boolean isAvailableSlot(){
        String adminMailId = getActiveUser();
        if (adminMailId != null){
            List<Slots> slots= getAllSlots(adminMailId);
            return slots.stream()
                    .anyMatch(slot -> slot.isSlotAvailability() && "Car".equalsIgnoreCase(slot.getVehicleType()));
        }
        else {
            return false;
        }
    }

}
