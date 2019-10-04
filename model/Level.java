package com.example.demo.practice.parkinglot.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Akash Deep
 **/

@Builder
@Data
public class Level {
    private int levelNumber;
    private int totalSlots;
}
