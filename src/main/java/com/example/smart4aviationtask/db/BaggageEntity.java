package com.example.smart4aviationtask.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class BaggageEntity {

    private int id;
    private final double weight;
    private final String weightUnit;
    private final int pieces;

    public BaggageEntity(final int id, final double weight, final String weightUnit, final int pieces) {
        this.id = id;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.pieces = pieces;
    }
}
