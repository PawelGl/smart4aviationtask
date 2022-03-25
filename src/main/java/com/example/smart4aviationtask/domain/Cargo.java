package com.example.smart4aviationtask.domain;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class Cargo {

    long id;
    UUID flightId;
    List<Baggage> baggage;
    List<Baggage> cargo;

    public double getFullBaggageWeight() {
        double weight = 0;
        for (Baggage baggage1 : baggage) {
            weight += baggage1.getFullWeightInKG();
        }
        return weight;
    }

    public double getFullCargoWeight() {
        double weight = 0;
        for (Baggage cargo1 : cargo) {
            weight += cargo1.getFullWeightInKG();
        }
        return weight;
    }

    int getAllBaggagePieces() {
        int pieces = 0;
        for (Baggage baggage1 : baggage) {
            pieces += baggage1.getPieces();
        }
        return pieces;
    }
}
