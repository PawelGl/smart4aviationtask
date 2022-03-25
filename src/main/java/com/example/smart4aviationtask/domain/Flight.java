package com.example.smart4aviationtask.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.time.Instant;
import java.util.UUID;


@Value
@Setter
@Getter
public class Flight {
    UUID flightId;
    int flightNumber;
    String departureAirportIATACode;
    String arrivalAirportIATACode;
    Instant departureDate;
    Cargo cargo;

    public int getAllBaggagePieces(){
        return cargo.getAllBaggagePieces();
    }
}
