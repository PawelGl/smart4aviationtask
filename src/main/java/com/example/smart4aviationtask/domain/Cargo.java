package com.example.smart4aviationtask.domain;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class Cargo {

    UUID flightId;
    List<Baggage> baggage;
    List<Baggage> cargo;

    public double getFullBaggageWeight() {
        return baggage.stream()
                .reduce(0D, (subtotalWeight, baggageWeight) -> subtotalWeight + baggageWeight.getFullWeightInKG(), Double::sum);
    }

    public double getFullCargoWeight() {
        return cargo.stream()
                .reduce(0D, (subtotalWeight, cargoWeight) -> subtotalWeight + cargoWeight.getFullWeightInKG(), Double::sum);
    }

    int getAllBaggagePieces() {
        return baggage.stream()
                .reduce(0, (subtotalWeight, baggagePieces) -> subtotalWeight + baggagePieces.getPieces(), Integer::sum);
    }
}
