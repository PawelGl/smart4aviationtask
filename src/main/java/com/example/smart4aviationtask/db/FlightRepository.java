package com.example.smart4aviationtask.db;

import com.example.smart4aviationtask.domain.Flight;

import java.util.Date;
import java.util.List;

public interface FlightRepository {

    Flight findByFlightNumberAndDepartureDate(final int flightNumber, final Date date);

    List<Flight> findAllByDepartureAirportIATACodeOrArrivalAirportIATACode(final String airportIATACode);
}
