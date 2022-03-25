package com.example.smart4aviationtask.db;

import com.example.smart4aviationtask.domain.Flight;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//TEST CLASS ONLY FOR MY TESTS, IF I FORGET TO REMOVE IT PLEASE DONT BE ANGRY :(
@RequiredArgsConstructor
public class FlightRepo implements FlightRepository {

    private final List<Flight> flightList;

    @Override
    public Flight findByFlightNumberAndDepartureDate(final int flightNumber, final Date date) {
        return flightList.stream().filter(flightEntity -> flightEntity.getFlightNumber() == flightNumber
                && flightEntity.getDepartureDate().equals(date.toInstant())).findFirst().orElse(null);
    }

    @Override
    public List<Flight> findAllByDepartureAirportIATACodeOrArrivalAirportIATACode(final String departureAirportIATACode, final String arrivalAirportIATACode){
        return flightList.stream().filter(flightEntity -> flightEntity.getDepartureAirportIATACode().equals(departureAirportIATACode)
                || flightEntity.getArrivalAirportIATACode().equals(arrivalAirportIATACode)).collect(Collectors.toList());
    }
}
