package com.example.demo.practice.parkinglot.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

/**
 * @author Akash Deep
 **/

@Builder
@Data
public class Slot {

    private int number;
    private Level level;

    @EqualsAndHashCode.Exclude
    private Vehical vehical;

    @EqualsAndHashCode.Exclude
    private Boolean isOccupied;
}
