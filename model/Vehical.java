package com.example.demo.practice.parkinglot.model;

import com.example.demo.practice.parkinglot.constant.VehicalType;
import lombok.Builder;
import lombok.Data;

/**
 * @author Akash Deep
 **/

@Builder
@Data
public class Vehical {
    private String registrationNo;
    private VehicalType vehicalType;
}
