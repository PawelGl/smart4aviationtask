package com.example.smart4aviationtask.application.dto;

import lombok.Getter;

@Getter
public class FlightLuggageWeightDto {
    private final double cargoWeight;
    private final double baggageWeight;
    private final double fullWeight;

    public FlightLuggageWeightDto(final double cargoWeight, final double baggageWeight) {
        this.cargoWeight = cargoWeight;
        this.baggageWeight = baggageWeight;
        this.fullWeight = cargoWeight + baggageWeight;
    }
}
