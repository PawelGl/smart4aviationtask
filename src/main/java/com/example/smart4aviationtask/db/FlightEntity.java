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
    private UUID flightId;
    private int flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private Instant departureDate;
    @OneToOne
    private CargoEntity cargo;
}
