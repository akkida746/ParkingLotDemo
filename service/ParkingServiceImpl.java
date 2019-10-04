package com.example.demo.practice.parkinglot.service;

import com.example.demo.practice.parkinglot.model.Level;
import com.example.demo.practice.parkinglot.model.ParkingSlip;
import com.example.demo.practice.parkinglot.model.Slot;
import com.example.demo.practice.parkinglot.model.Vehical;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang.ObjectUtils;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author Akash Deep
 **/

public class ParkingServiceImpl extends ParkingService {

    @Builder(builderMethodName = "parkingserviceimpl")
    public ParkingServiceImpl(int levels, int slots){
        super(levels, slots);
    }

    @Override
    public Optional<ParkingSlip> park(Vehical vehical) {
        Optional<Slot> slotOptional = getSlot();
        Slot slot = slotOptional.get();
        slot.setVehical(vehical);
        slot.setIsOccupied(true);

        ParkingSlip parkingSlip = ParkingSlip.builder()
                .slipNumber(vehical.getRegistrationNo()).slot(slot).build();
        getParkingSlipVehicalMap().put(parkingSlip, vehical);
        getLevelSlotMap().put(slot.getLevel(),slot);
        getSlotVehicalMap().put(slot, vehical);
        return Optional.of(parkingSlip);
    }

    @Override
    public Optional<Slot> getSlot(){
        return Optional.of(getVacantSlots().poll());
    }

    @Override
    public void exit(ParkingSlip parkingSlip) {
        Map<ParkingSlip, Vehical> parkingSlipVehicalMap = getParkingSlipVehicalMap();
        Vehical vehical = parkingSlipVehicalMap.get(parkingSlip);
        parkingSlipVehicalMap.remove(parkingSlip);
        Slot slot = parkingSlip.getSlot();
        Map<Slot, Vehical> slotVehicalMap = getSlotVehicalMap();
        slotVehicalMap.remove(slot);
        slot.setIsOccupied(false);
        getVacantSlots().add(slot);
    }


}
