package com.carparking.project.repository;

import com.carparking.project.entities.Slots;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotsRepository extends CrudRepository<Slots, Integer> {

    public List<Slots> findByAdminMailId(String adminMailId);
}
