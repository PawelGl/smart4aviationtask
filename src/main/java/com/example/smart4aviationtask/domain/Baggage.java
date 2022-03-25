package com.example.smart4aviationtask.domain;

import lombok.Value;

@Value
public class Baggage {

    int id;
    //TODO : weight + weightUnit = VO
    double weight;
    String weightUnit;
    int pieces;

    double getFullWeightInKG() {
        if (weightUnit.equals("kg")) {
            return weight * pieces;
        }
        return weight * 0.45 * pieces;
    }

    int getPieces() {
        return pieces;
    }
}
