package com.example.smart4aviationtask.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table
@Setter
@Getter
public class FlightEntity {
    @Id
    @GeneratedValue
    UUID flightId;
    int flightNumber;
    String departureAirportIATACode;
    String arrivalAirportIATACode;
    Instant departureDate;
    @OneToOne
    CargoEntity cargo;
}
