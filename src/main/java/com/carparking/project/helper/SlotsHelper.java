package com.carparking.project.helper;

import com.carparking.project.entities.Slots;
import com.carparking.project.service.SlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Service
public class SlotsHelper {

    @Autowired
    SlotsService slotsService;
        private PriorityQueue<Slots> availableSlots; // Min-heap for available slots
        private final Map<Slots, String> slotToCar; // Mapping of slot to car registration number

        // Constructor
        public SlotsHelper() {
            this.availableSlots = new PriorityQueue<>();
            this.slotToCar = new HashMap<>();
        }

        public  String getActiveuser()
        {
            return slotsService.getActiveUser();
        }
        // Allocate a parking slot to a car
        public Slots parkCar(String vehiclenum) {
            List<Slots> slots = slotsService.getAllSlots(getActiveuser());
            availableSlots=new PriorityQueue<>(slots);
            if (availableSlots.isEmpty()) {
                return null;
            }

            Slots slot = availableSlots.poll(); // Get the nearest available slot
            slotToCar.put(slot, vehiclenum);
            return slot;
        }

        // Remove a car from a parking slot
        public String leaveSlot(Slots slot) {
            if (!slotToCar.containsKey(slot)) {
                return "Slot is already empty or invalid";
            }

            slotToCar.remove(slot);
            availableSlots.add(slot); // Make the slot available again
            return "Slot " + slot + " is now available";
        }


    }


