package com.example.demo.practice.parkinglot;

import com.example.demo.practice.parkinglot.constant.VehicalType;
import com.example.demo.practice.parkinglot.model.Car;
import com.example.demo.practice.parkinglot.model.ParkingSlip;
import com.example.demo.practice.parkinglot.model.Vehical;
import com.example.demo.practice.parkinglot.service.ParkingService;
import com.example.demo.practice.parkinglot.service.ParkingServiceImpl;
import lombok.Builder;

import java.util.Optional;

/**
 * @author Akash Deep
 **/
public class ParkingLotDemo {
    public static void main(String[] args) {
        int levels = 3;
        int slots = 10;
        ParkingService parkingService = ParkingServiceImpl.parkingserviceimpl()
                .levels(3).slots(slots).build();
        System.out.println("Levels: " + parkingService.getLevels());
        System.out.println("Slots: " + parkingService.getLevelSlotMap().get(0));

        Vehical car1 = Car.carbuilder().registrationNo("UP23S1648")
                .vehicalType(VehicalType.CAR).build();
        Vehical car2 = Car.carbuilder().registrationNo("UP23S1649")
                .vehicalType(VehicalType.CAR).build();

        Optional<ParkingSlip> parkingSlipOptional1 = parkingService.park(car1);
        Optional<ParkingSlip> parkingSlipOptional2 = parkingService.park(car2);
        System.out.println(parkingSlipOptional1.get().getSlot().getLevel());
        System.out.println(parkingSlipOptional2.get().getSlot().getLevel());
        System.out.println(parkingService.getVacantSlots().size());

        System.out.println(parkingService.getParkingSlipVehicalMap().get(parkingSlipOptional1.get()).getRegistrationNo());
        System.out.println(parkingService.getParkingSlipVehicalMap().get(parkingSlipOptional2.get()).getRegistrationNo());
    }
}
