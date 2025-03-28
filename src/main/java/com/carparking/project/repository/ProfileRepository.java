package com.carparking.project.repository;

import com.carparking.project.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {
    List<Profile> findByAdminMailId(String adminMailId);

    Profile findByVehicleNumber(String vehicleNumber);

    List<Profile> findByUserEmailId(String userMail);

    Profile findByallocatedSlotNumber(String allocatedSlotNumber);



}
