package com.example.smart4aviationtask.domain;


public class Baggage {

    private int id;
    //TODO : weight + weightUnit = VO
    private final double weight;
    private final String weightUnit;
    private final int pieces;

    public Baggage(final int id, final double weight, final String weightUnit, final int pieces) {
        this.id = id;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.pieces = pieces;
    }

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
