package com.example.demo.practice.parkinglot.service;

import com.example.demo.practice.parkinglot.model.Level;
import com.example.demo.practice.parkinglot.model.ParkingSlip;
import com.example.demo.practice.parkinglot.model.Slot;
import com.example.demo.practice.parkinglot.model.Vehical;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Akash Deep
 **/

@Data
public abstract class ParkingService {

    private int levels;
    private int slots;
    private Map<Level, Slot> levelSlotMap = new HashMap<>();
    private Map<Slot, Vehical> slotVehicalMap = new HashMap<>();
    private Map<ParkingSlip, Vehical> parkingSlipVehicalMap = new HashMap<>();
    private PriorityQueue<Slot> vacantSlots = new PriorityQueue<>(
            (Slot s1, Slot s2) -> (s1.getLevel().getLevelNumber()-s2.getLevel().getLevelNumber())
    );

    public ParkingService(int levels, int slots){
        this.levels = levels;
        this.slots = slots;
        createParkingLot(this.levels, this.slots);
    }

    public abstract Optional<ParkingSlip> park(Vehical vehical);
    public abstract Optional<Slot> getSlot();
    public abstract void exit(ParkingSlip parkingSlip);

    private final void createParkingLot(int levels, int slots) {
        for(int i=1;i<=levels;i++){
            Level level = Level.builder().levelNumber(i).totalSlots(slots).build();
            addLevel(level, slots);
        }
    }

    protected final void addLevel(Level level, int slots){
        for(int i=1;i<=slots;i++){
            Slot slot = Slot.builder().level(level).number(i).build();
            levelSlotMap.put(level, slot);
            vacantSlots.add(slot);
        }
    }
}
