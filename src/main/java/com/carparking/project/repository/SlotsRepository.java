package com.carparking.project.repository;

import com.carparking.project.entities.Slots;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SlotsRepository extends CrudRepository<Slots, Integer> {

    public List<Slots> findByAdminMailId(String adminMailId);

    @Modifying
    @Transactional
    @Query("UPDATE Slots s SET s.slotAvailability = :slotAvailability, s.vehicleNum = :vehicleNum, s.startTime = :startTime, s.exitTime = :exitTime WHERE s.slotId = :slotId")
    void updateSlotAvailability(int slotId, boolean slotAvailability, String vehicleNum, String startTime, String exitTime);
}
