package com.example.smart4aviationtask.domain;


import lombok.Value;

import java.time.Instant;
import java.util.UUID;


@Value
public class Flight {
    UUID flightId;
    int flightNumber;
    String departureAirportIATACode;
    String arrivalAirportIATACode;
    Instant departureDate;
    Cargo cargo;

    public int getAllBaggagePieces() {
        return cargo.getAllBaggagePieces();
    }
}
