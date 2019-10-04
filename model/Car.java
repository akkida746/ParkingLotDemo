package com.example.demo.practice.parkinglot.model;

import com.example.demo.practice.parkinglot.constant.VehicalType;
import lombok.Builder;

/**
 * @author Akash Deep
 **/

public class Car extends Vehical {

    @Builder(builderMethodName = "carbuilder")
    Car(String registrationNo, VehicalType vehicalType) {
        super(registrationNo, vehicalType);
    }
}
